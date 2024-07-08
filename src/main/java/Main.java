import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    private static final String filePath = "./result.txt";

    public static void main(String[] args) throws IOException {
        NaverNewsCrawler naverNewsCrawler = new NaverNewsCrawler();

        List<Article> allArticles = naverNewsCrawler.getAllArticles();
        StringJoiner content = new StringJoiner("\n,");
        allArticles.forEach(article -> content.add(article.toString()));

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
