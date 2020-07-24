package algorithms.challenges;

import java.util.*;
import java.util.Map.Entry;

class FindUniqueNumber {
    public static Integer findUnique(List<Integer> example) {
        Map<Integer, Integer> itemSeq = new HashMap<>();
        example.forEach(num -> {
                    if (itemSeq.containsKey(num)) {
                        itemSeq.put(num, itemSeq.get(num) + 1);
                    } else {
                        itemSeq.put(num, 1);
                    }
                }
        );
        Optional<Entry<Integer, Integer>> entryResult = itemSeq.entrySet().stream().filter(e ->
                e.getValue() == 1
        ).findFirst();
        return entryResult.isEmpty() ? 0 : entryResult.get().getKey();
    }

    public static void main(String[] args) {
        List<Integer> example0 = Arrays.asList(0, 1, 0, 1, 5); //5
        List<Integer> example1 = Arrays.asList(0, 1, 0, 1, 5); //5
        List<Integer> example2 = Arrays.asList(9); // 9
        List<Integer> example3 = Arrays.asList(0, 0, -1, -1, 13131, 2, 2); // 13131

        System.out.println("The unique item for example1 is: " + findUnique(example1));
        System.out.println("The unique item for example2 is: " + findUnique(example2));
        System.out.println("The unique item for example3 is: " + findUnique(example3));


        try {

            // creating Arrays of String type
            String a[] = new String[]{"A", "B", "C", "D"};

            // getting the list view of Array
            List<String> list = Arrays.asList("A", "B", "C", "D");

            // printing the list
            System.out.println("The list is: " + list);
        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}