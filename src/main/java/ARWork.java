import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ARWork {

    public static Map<String, Integer> extrackStringToMap(String input) {
        Map<String, Integer> map = new HashMap<>();
        String [] subString = input.split("([^A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]+)");

        for (String word : subString) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word,1);
            }
        }
        System.out.println(map);
        return map;
    }

    public static Map <String, Integer> sortMapByKeyAscending(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapJava8 =
                inputMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMapJava8;
    }

    public static Map<String,Integer> sortMapByKeyDescending(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapJava8 =
                inputMap.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return sortedMapJava8;
    }
}
