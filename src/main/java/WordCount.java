import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordCount {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("http://en.wikipedia.org/").get();
        String text = document.body().text();

        System.out.println(text);

        Map<String, Word> countMap = new HashMap<String, Word>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("(?=[,.])");
            for (String word : words) {
                if ("".equals(word)) {
                    continue;
                }

                Word wordObj = countMap.get(word);
                if (wordObj == null) {
                    wordObj = new Word();
                    wordObj.word = word;
                    wordObj.count = 0;
                    countMap.put(word, wordObj);
                }
                wordObj.count++;
            }
        }
        reader.close();

        SortedSet<Word> sortedWords = new TreeSet<Word>(countMap.values());
        int i = 0;
        for (Word word : sortedWords) {
            if (i > 10) {
                break;
            }
            System.out.println(word.count + "\t" + word.word);
            i++;
        }
    }
}


