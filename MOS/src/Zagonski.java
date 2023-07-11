import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Zagonski {
    public static List<String[]> readCSV(String filename) {
        List<String[]> result = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] strings = line.split(","); // razdelimo z vejicami
                    result.add(strings);
                }
            }

            br.close();
        } catch (Exception e) { e.printStackTrace(); }

        return result;
    }
}
