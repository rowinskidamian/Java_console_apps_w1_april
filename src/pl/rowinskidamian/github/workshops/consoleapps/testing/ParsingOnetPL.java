package pl.rowinskidamian.github.workshops.consoleapps.testing;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileWriter;
import java.io.IOException;

public class ParsingOnetPL {

    public static void main(String[] args) {

        String fileNameToWrite = "titlesFromOnet.pl.txt";

        Connection connect = Jsoup.connect("https://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            // selector docs https://jsoup.org/cookbook/extracting-data/selector-syntax

            FileWriter fileWriter = new FileWriter(fileNameToWrite);
            int counterOfElements = 1;

            for (Element elem : links) {
                fileWriter.append(counterOfElements + " " + elem.text());
                fileWriter.append("\n");
                counterOfElements++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

