package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
public class Differ {

    public static String generate(String file1, String file2) throws IOException {

        Path writeFilePath1 = Paths.get(file1).toAbsolutePath().normalize();
        Path writeFilePath2 = Paths.get(file2).toAbsolutePath().normalize();
        String content1 = Files.readString(writeFilePath1);
        String content2 = Files.readString(writeFilePath2);
        ObjectMapper map = new ObjectMapper();
        Map<String, Object> data1 = map.readValue(content1, Map.class);
        Map<String, Object> data2 = map.readValue(content2, Map.class);

        StringBuilder diff = new StringBuilder();
        diff.append("{ \n");
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(data1.keySet());
        set.addAll(data2.keySet());
        for (var s : set) {
            if (!data1.containsKey(s)) {
                diff.append(" + " + s + ": " + data2.get(s) + "\n");
            } else if (!data2.containsKey(s)) {
                diff.append(" - " + s + ": " + data1.get(s) + "\n");
            } else {
                if (data2.get(s).equals(data1.get(s))) {
                    diff.append("   " + s + ": " + data1.get(s) + "\n");
                } else {
                    diff.append(" - " + s + ": " + data1.get(s) + "\n");
                    diff.append(" + " + s + ": " + data2.get(s) + "\n");

                }
            }
        }
        diff.append("}");
        return diff.toString();
    }
    public static String getData(String file) throws IOException {
        Path path = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
