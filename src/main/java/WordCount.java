import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) throws IOException {

        String nazwaStrony = "https://www.onet.pl/";
        Document document = Jsoup.connect(nazwaStrony).get();
        String text = document.body().text();

        //System.out.println(text);

        Map<String, Integer> mapa = ARWork.extrackStringToMap(text);
        System.out.println(ARWork.sortMapByKeyAscending(mapa));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String requiredDate = df.format(new Date()).toString();
        System.out.println(requiredDate);

        OutputToFile.output(ARWork.sortMapByKeyAscending(mapa), nazwaStrony, requiredDate);


    }

}




