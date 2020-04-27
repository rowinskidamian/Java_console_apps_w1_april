package pl.rowinskidamian.github.workshops.consoleapps;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileWriter;
import java.io.IOException;

public class ParsingWebsite {

    public static void startApp() {

        String fileNameToWrite = "titleBusinessInsider.txt";

        Connection connect = Jsoup.connect("https://businessinsider.com.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("a.title");
            // selector docs https://jsoup.org/cookbook/extracting-data/selector-syntax

            FileWriter fileWriter = new FileWriter(fileNameToWrite);
            int counterOfElements = 1;

            for (Element elem : links) {
                fileWriter.append(counterOfElements + " " + elem.text());
                fileWriter.append("\n");
                counterOfElements++;
                System.out.println(elem.text());
//                System.out.println("link : " + elem.attr("href"));
//                System.out.println("text : " + elem.text());
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
