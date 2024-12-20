package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
public class Differ {

    public static String generate(Map<String, Object> data1, Map<String, Object> data2) {
        //Map<String, Object> sortedMap1 = new TreeMap<>(data1);
       //Map<String, Object> sortedMap2 = new TreeMap<>(data2);
        //System.out.println(sortedMap1);
        //System.out.println(sortedMap2);
        //System.out.println(sortedMap1.keySet().equals(sortedMap2.keySet()));
        //System.out.println(sortedMap1.keySet());
        //System.out.println(sortedMap2.keySet());

        StringBuilder diff = new StringBuilder();
        diff.append("{ \n");
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(data1.keySet());
        set.addAll(data2.keySet());
        for (var s : set) {
            //System.out.println("Key: " + s);
            //System.out.println("Value: " + s.getValue());
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
        //System.out.println(diff);
        return diff.toString();
    }


}
