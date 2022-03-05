import java.util.Scanner;
import java.lang.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpEntity;
import org.apache.commons.io.FileUtils;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.io.InputStream;
//import java.net.URL;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;

//#row-304546280 > div > div > div > div > div > div > div:nth-child(4)
//#row-1965244831 > div > div > div > div > div > div > div:nth-child(4) > div.rankingTab > div.selectionWrap > div:nth-child(1) > div:nth-child(1) > div.deviceName.flex-col.flex-left.flex-grow > h3 //Camera 1st
//#row-1965244831 > div > div > div > div > div > div > div:nth-child(4) > div.rankingTab > div.selectionWrap > div:nth-child(1) > div:nth-child(1) > div.deviceScore.flex-col.flex-right //144 Score
//#row-1965244831 > div > div > div > div > div > div > div:nth-child(8) > div.rankingTab > div.selectionWrap > div:nth-child(1) > div:nth-child(1) > div.deviceName.flex-col.flex-left.flex-grow > h3 //Selfie 1st
//#slick-slide00 > div.rankingTab > div.selectionWrap > div:nth-child(1) > div:nth-child(1) > div.deviceName.flex-col.flex-left.flex-grow > h3

public class DXOMARK_Top_5 {
    public static void main(String[] args) throws IOException {
        String home = System.getProperty("user.home"); //https://www.796t.com/post/MmNtYzI=.html

        String Source = ("https://www.dxomark.com/"); //下載來源網址
        System.out.print("\n下載來源網址：" + Source + "\n");

        //String path = (home + "\\Downloads\\" + "\\");
        String path = (home + "/Downloads/" + "/"); //for macOS

        try {
            Document doc = Jsoup.connect(Source).get();
            System.out.println(doc.title());

            Elements rankingTab = doc.getElementsByClass("rankingTab");//從doc中選擇rankingTab裡面
            for (Element Top_5 : rankingTab) { //在rankingTab裡面抓出devices
                Elements devices = doc.getElementsByClass("deviceName flex-col flex-left flex-grow");
                for (Element Top : devices) { //在devices裡面抓出Device Name
                    String Camera = Top.getElementsByTag("h3").text();
                    System.out.println(Camera);
                    Elements newsHeadlines = doc.select("div.rankingTab div.deviceName.flex-col.flex-left.flex-grow h3 a");
                    for (Element attachment : newsHeadlines) {
                        //String Camera = Top.getElementsByTag("a").text();
                        String href = attachment.absUrl("href");
                        System.out.println("網址：" + attachment.absUrl("href")); //網址
                    }
                }
            }
            Elements Image = doc.select("#Image1"); //封面
            //System.out.println("封面：" + Image);
            //Element Image = doc.getElementById("Image1");
            //System.out.println("封面：" + Image);
            for (Element corver : Image) {
                System.out.println("封面下載網址：" + corver.absUrl("src")); //封面下載網址

                String src = corver.absUrl("src");

                //https://www.delftstack.com/zh-tw/howto/java/java-remove-character-from-string/#%E5%9C%A8-java-%E4%B8%AD%E4%BD%BF%E7%94%A8-replace-%E5%87%BD%E5%BC%8F%E5%BE%9E%E5%AD%97%E4%B8%B2%E4%B8%AD%E5%88%AA%E9%99%A4%E5%AD%97%E5%85%83
                String front_cover = src.replace("http://www.gotop.com.tw/Waweb2004/WawebImages/bookXL/", "");

                System.out.println("封面名稱：" + front_cover);
            }

            //Elements Writer = doc.select("#Label2"); //作者
            //System.out.println("作者：" + Writer);
            Element Writer = doc.getElementById("Label2"); //作者
            System.out.println("作者：" + Writer.text());

            //Elements ISBN = doc.select("#Label3"); //ISBN
            //System.out.println("ISBN：" + ISBN);
            Element ISBN = doc.getElementById("Label3"); //ISBN
            System.out.println("ISBN：" + ISBN.text());

            System.out.println("Copyright © 2008-2022 DXOMARK. All rights reserved");

        } catch (Exception e) {
            System.out.println("\nerror: " + e);
        }
//#rank > div.mobile-rank > div > div > div.col-xs-12.col-lg-9 > div > div.tab-content > div > ul:nth-child(5) > a > div.nrank-b > li.bfirst > font > font
//#section1 > div.mainbor.mt2 > div.m_l.fl > ul:nth-child(3) > div.nrank-b > li.bfirst
        try {
            Document doc1 = Jsoup.connect("https://www.antutu.com/en/ranking/rank1.htm").get();
            System.out.println(doc1.title());
            Elements devices = doc1.getElementsByClass("nrank-b");
            for (Element Name : devices) { //在devices裡面抓出Device Name
                Elements newsHeadlines = doc1.getElementsByClass("bfirst");
                String N = Name.getElementsByTag("li").text();
                System.out.println(N); //網址
                for (Element attachment : newsHeadlines) {
                    //String href = attachment.absUrl("href");
                    //System.out.println(N); //網址
                }
            }
            Elements Image = doc1.select("#Image1"); //封面
            //System.out.println("封面：" + Image);
            //Element Image = doc.getElementById("Image1");
            //System.out.println("封面：" + Image);
            for (Element corver : Image) {
                System.out.println("封面下載網址：" + corver.absUrl("src")); //封面下載網址

                String src = corver.absUrl("src");

                //https://www.delftstack.com/zh-tw/howto/java/java-remove-character-from-string/#%E5%9C%A8-java-%E4%B8%AD%E4%BD%BF%E7%94%A8-replace-%E5%87%BD%E5%BC%8F%E5%BE%9E%E5%AD%97%E4%B8%B2%E4%B8%AD%E5%88%AA%E9%99%A4%E5%AD%97%E5%85%83
                String front_cover = src.replace("http://www.gotop.com.tw/Waweb2004/WawebImages/bookXL/", "");

                System.out.println("封面名稱：" + front_cover);
            }

            //Elements Writer = doc.select("#Label2"); //作者
            //System.out.println("作者：" + Writer);
            Element Writer = doc1.getElementById("Label2"); //作者
            System.out.println("作者：" + Writer.text());

            //Elements ISBN = doc.select("#Label3"); //ISBN
            //System.out.println("ISBN：" + ISBN);
            Element ISBN = doc1.getElementById("Label3"); //ISBN
            System.out.println("ISBN：" + ISBN.text());

            System.out.println("Copyright © 2008-2022 DXOMARK. All rights reserved");

        } catch (Exception e) {
            System.out.println("\nerror: " + e);
        }
    }
}
