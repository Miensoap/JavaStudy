package org.example;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Main {
    private static final String filePath = "./result.txt";

    public static void main(String[] args) throws IOException {
        NaverNewsCrawler naverNewsCrawler = new NaverNewsCrawler();

        List<Article> allArticles = naverNewsCrawler.getAllArticles();
        Set<String> existingLinks = getExistingLinks();

        List<Article> newArticles = allArticles.stream()
            .filter(article -> !existingLinks.contains(article.link()))
            .toList();

        System.out.println(newArticles.size() + "개의 뉴스를 새로 가져왔습니다!");
        writeResult(newArticles);
    }

    private static void writeResult(List<Article> articles) {
        StringJoiner content = new StringJoiner("\n");
        articles.forEach(article -> content.add(article.toString()));
        if (!content.toString().isBlank()) content.add("");

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath, true), StandardCharsets.UTF_8))) {
            writer.write(content.toString());
        } catch (IOException e) {
            System.out.println("파일 쓰기 실패");
        }
    }

    private static Set<String> getExistingLinks() {
        Set<String> existingLinks = new HashSet<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            existingLinks = reader.lines()
                    .map(Main::getLineUrl)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            // 파일이 없으면 중복 없음
        }
        return existingLinks;
    }

    private static String getLineUrl(String line){
        try {
            return line.substring(line.lastIndexOf("(") + 1, line.lastIndexOf(")"));
        }catch (StringIndexOutOfBoundsException e ){
            return "";
        }
    }
}
