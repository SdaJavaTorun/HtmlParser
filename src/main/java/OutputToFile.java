import javafx.scene.input.DataFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class OutputToFile {

    public static void output(Map<String, Integer> mapa, String nazwaStrony, String data) throws IOException {

        File output = new File ( "C://Users//RENT//Desktop//output.txt" );

        FileWriter fw = new FileWriter (output, true);
        PrintWriter pw = new PrintWriter (output);
        pw.println (nazwaStrony + data);
        pw.println(mapa);
        pw.close();
    }
}
