package algorithms.common;

import java.util.*;
import java.util.Map.Entry;

public class ConvertArrayToLinkedHashMap<Key extends Comparable<Key>, Value extends Comparable<Value>> {

    static Map<String, Integer> convertArrayToMap(String[] arr) {
        //init a hashmap with array
        Map<String, Integer> str_num = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            str_num.put(arr[i], i);
        }
        //sort entry list of the the map using Collections.sort(List) function
        List<Entry<String, Integer>> entryList = new ArrayList<>(str_num.entrySet());
        Collections.sort(entryList, (Entry<String, Integer> o1, Entry<String, Integer> o2) -> {
            return o1.getValue() - o2.getValue();
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        entryList.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }

    /**
     * 1, construct List using map's entrySet
     * 2, use Collections.sort() api to sort the generated List using given Comparator lambbda expression.
     * 3, return sorted list.
     */
    static List<Entry<String, Integer>> sortHashMapByValue(HashMap<String, Integer> hm) {
        List<Entry<String, Integer>> entryList = new ArrayList<>(hm.entrySet());
        Collections.sort(entryList, (Entry<String, Integer> o1, Entry<String, Integer> o2) -> {
            int cmp = o1.getValue().compareTo(o2.getValue());
            return cmp == 0 ? o1.getKey().compareTo(o2.getKey()) : cmp;
        });
        return entryList;
    }

    List convertMapToList(Key k, Value v) {
        Map<Key, Value> map = new HashMap<Key, Value>();
        List<Entry<Key, Value>> l = new ArrayList(map.entrySet());
        Collections.sort(l, (Entry<Key, Value> o1, Entry<Key, Value> o2) -> {
            int cmp = o1.getValue().compareTo(o2.getValue());
            return cmp == 0 ? o1.getKey().compareTo(o2.getKey()) : cmp;
        });
        return l;
    }

    public static void main(String[] args) {
        String[] arr = {"this", "that", "something", "a", "c", "b", "e"};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> {
            int cmp = o1.getValue().compareTo(o2.getValue());
            return cmp == 0 ? o1.getKey().compareTo(o2.getKey()) : cmp;
        });
        entryList.forEach((Entry<String,Integer> item) ->{
            System.out.println((item.getKey() + " --- " + item.getValue()));
        });

        Map<String, Integer> sortedMap = convertArrayToMap(arr);
        sortedMap.forEach((k, v) -> {
            System.out.println(k + " --- " + v);
        });
    }
}
