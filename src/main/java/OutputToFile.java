import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class OutputToFile {

    public static void writeToFile(Map<String, Integer> mapa,
                                   String nazwaStrony,
                                   String data,
                                   String shortPageName)
            throws IOException {

        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        String dateFormatToFileName = df.format(new Date()).toString();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("src/txtOutput/");
        stringBuilder.append(dateFormatToFileName);
        stringBuilder.append("_");
        stringBuilder.append(shortPageName);
        stringBuilder.append(".txt");
        File output = new File (String.valueOf(stringBuilder));

        FileWriter fw = new FileWriter (output, true);
        PrintWriter pw = new PrintWriter (output);
        pw.println (nazwaStrony + "  " +  data);

        for (Map.Entry<String, Integer> p : mapa.entrySet()){
            pw.println(p.getKey() + " = " + p.getValue());
        }
        pw.close();
    }
}
