import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ARWorkTest {
    @Test
    public void shouldReturnsMapSizeOfThree() {
        String sentence = "mango torun dom dom torun mango";
        Map<String, Integer> map = ARWork.extrackStringToMap(sentence);
        assertEquals(3, map.size());
    }

    @Test
    public void shouldReturnsMapSizeOfFive() {
        String sentence = "mango torun dom dom torun mango torun2 dom2 dom torun mango";
        Map<String, Integer> map = ARWork.extrackStringToMap(sentence);
        assertEquals(5, map.size());
    }

    @Test
    public void shouldSortMapInAscendingOrder() {
        Map<String, Integer> map =
                new HashMap<String, Integer>(){{
                    put("jesika", 4);
                    put("dzoanna", 6);
                    put("sebix", 3);
                    put("Ezoanna", 6);
                    put("Azoanna", 6);
                    put("karyna", 1);
                    put("brajanusz", 2);
                }};
        Map<String, Integer> sortedMap =
                new HashMap<String, Integer>(){{
                    put("Azoanna", 6);
                    put("Ezoanna", 6);
                    put("brajanusz", 2);
                    put("dzoanna", 6);
                    put("jesika", 4);
                    put("karyna", 1);
                    put("sebix", 3);
                }};

        Map<String, Integer> outputMap = ARWork.sortMapByKeyAscending(map);
        System.out.printf(outputMap.toString());
        assertEquals(outputMap, sortedMap);
    }

    @Test
    public void shouldSortMapInDescendingOrder() {
        Map<String, Integer> map =
                new HashMap<String, Integer>(){{
                    put("jesika", 4);
                    put("dzoanna", 6);
                    put("Ezoanna", 6);
                    put("sebix", 3);
                    put("karyna", 1);
                    put("brajanusz", 2);
                }};
        Map<String, Integer> sortedMap =
                new HashMap<String, Integer>(){{
                    put("Ezoanna", 6);
                    put("brajanusz", 2);
                    put("dzoanna", 6);
                    put("jesika", 4);
                    put("karyna", 1);
                    put("sebix", 3);

                }};

        Map<String, Integer> outputMap = ARWork.sortMapByKeyDescending(map);
        assertEquals(outputMap, sortedMap);
    }

    @Test
    public void shouldSortWithCaseSensitiveOrder() {
        Map<String, Integer> inputMap =
                new HashMap<String, Integer>(){{
                    put("jesika", 4);
                    put("dzoanna", 6);
                    put("sebix", 3);
                    put("karyna", 1);
                    put("brajanusz", 2);
                }};

        Map<String, Integer> outputMap = inputMap.entrySet().stream()
                //.Collections.sort(inputMap, String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}