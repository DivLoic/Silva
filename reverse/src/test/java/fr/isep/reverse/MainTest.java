package fr.isep.reverse;

import java.io.*;

/**
 * Created by LoicMDIVAD on 27/12/2015.
 */
public class MainTest {

    /*
    Here is a few utils foction in order to simplify
    the wrinting of the tests
     */
    private static final File resourceFolder = new File("src/test/resource");

    public static String testRead(String filename, String err) throws IOException {
        File f = new File(resourceFolder + "/" + filename);
        if(f.exists()){
            InputStream in = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line; String doc;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            reader.close();
            return out.toString();
        } else {
            return err;
        }

    }
}
