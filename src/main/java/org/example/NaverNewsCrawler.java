package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import static org.example.NaverNewsConsts.*;

public class NaverNewsCrawler {
    private final String baseUrl = BASE_URL;

    public List<Article> getAllArticles() {
        Set<String> topicNames = TOPICS.keySet();

        return topicNames.stream()
                .map(this::getArticlesOfTopic)
                .flatMap(List::stream)
                .toList();
    }

    public List<Article> getArticlesOfTopic(String topicName) {
        String topicPath = TOPICS.get(topicName);
        List<Article> results = new ArrayList<>();

        for (Map.Entry<String, String> detailTopic : DETAIL_TOPICS.get(topicName).entrySet()) {
            String detailTopicName = detailTopic.getKey();
            String detailTopicPath = detailTopic.getValue();

            String fullTopic = topicName + " - " + detailTopicName;
            String url = makeUrl(topicPath, detailTopicPath);

            try {
                Document document = getDocument(url);
                Elements articles = document.select(ARTICLE_CSS);

                articles.forEach(article -> results.add(parseArticle(article, fullTopic)));
            } catch (IOException e) {
                System.out.printf(
                        "%s 주제의 뉴스 가져오기 실패. : %s",
                        fullTopic,
                        url
                );
            }
        }

        return results;
    }

    private Article parseArticle(Element article, String fullTopic) {
        String title = article.select(ARTICLE_TITLE_CSS).text();
        String link = article.select(ARTICLE_LINK_CSS).attr("href");
        String lede = article.select(ARTICLE_LEDE_CSS).text();
        String press = article.select(ARTICLE_PRESS_CSS).text();

        return new Article(title, link, lede, press, fullTopic);
    }

    private String makeUrl(String topic, String detailTopic) {
        StringJoiner sj = new StringJoiner("/");
        sj.add(this.baseUrl);
        sj.add(topic).add(detailTopic);
        return sj.toString();
    }

    private Document getDocument(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        document.outputSettings().charset(StandardCharsets.UTF_8);
        return document;
    }
}
