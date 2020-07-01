package algorithms.common;

import java.util.*;

/**
 * convert Set to List and use Collections.sort(List<E>,Comparator<E>)
 * you need to pass your customized value comparator.
 */
public class SortHashMapByValue {

    List<Map.Entry<String, Integer>> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hm.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        return entryList;
    }

    Queue<Map.Entry<String, Integer>> sortByValueToPQ(HashMap<String, Integer> hm) {
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(hm.size(), (o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
        pq.addAll(hm.entrySet());
        return pq;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Operating System", 85);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Networking", 80);

        SortHashMapByValue sortHashMapByValue = new SortHashMapByValue();
        List<Map.Entry<String, Integer>> sortedEntires = sortHashMapByValue.sortByValue(hm);
        sortedEntires.forEach(entry -> {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        });

        Queue<Map.Entry<String, Integer>> pq = sortHashMapByValue.sortByValueToPQ(hm);

        int k = 4;
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}

