import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) throws IOException {

        System.out.println("Podaj adres strony");
        System.out.print("https://");
        Scanner sc = new Scanner(System.in);
        String adres = sc.nextLine();
        String nazwaStrony = "https://"+adres;
        Document document = Jsoup.connect(nazwaStrony).get();
        String text = document.body().text();

        //System.out.println(text);

        Map<String, Integer> mapa = ARWork.extracktStringToMap(text);
        System.out.println(ARWork.sortMapByKeyAscending(mapa));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String requiredDate = df.format(new Date()).toString();
        System.out.println(requiredDate);

        OutputToFile.output(ARWork.sortMapByKeyAscending(mapa), nazwaStrony, requiredDate);

    }

}




