package algorithms.common;

import java.util.*;
import java.util.Map.Entry;

public class ConvertArrayToLinkedHashMap<Key extends Comparable<Key>, Value extends Comparable<Value>> {

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

    /**
     *
     * @param k
     * @param v
     * @return
     */
    List convertMapToEntryList(Key k, Value v) {
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
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.forEach((Entry<String, Integer> item) -> {
            System.out.println((item.getKey() + " --- " + item.getValue()));
        });
    }
}
