
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * A simple example, used on the jsoup website.
 */
public class Spider {
    public static void main(String[] args) throws IOException {
        try {
            Document doc = Jsoup.connect("https://en.m.wikipedia.org/").get();
            System.out.println("doc.title(): " + doc.title());

            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Document doc = Jsoup.connect("https://rule.nkust.edu.tw/").get();
            System.out.println("doc.title(): " + doc.title());

            Elements newsHeadlines = doc.select("#Dyn_2_2 div.mtitle a");
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Document doc = Jsoup.connect("https://www.ptt.cc/bbs/index.html").get();
            System.out.println("doc.title(): " + doc.title());

            Elements newsHeadlines = doc.select("#main-container a.board");
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        try {
            Document doc = Jsoup.connect("https://www.ptt.cc/bbs/Gossiping/M.1638258698.A.66E.html").get();
            System.out.println("doc.title(): " + doc.title());

            Elements newsHeadlines = doc.select("#span.article-meta-value");
            for (Element headline : newsHeadlines) {
                System.out.println(headline.attr("title"));
                System.out.println(headline.absUrl("href"));
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

        Document doc = Jsoup.connect("http://www.yiibai.com").get();
        String keywords = doc.select("meta[name=keywords]").first().attr("content");
        System.out.println("Meta keyword : " + keywords);
        String description = doc.select("meta[name=description]").get(0).attr("content");
        System.out.println("Meta description : " + description);
    }
}