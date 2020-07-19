import java.util.*;


/**
 * Arrays.fill() api.
 * <p>
 * Collections.min() api, make your code concise. with Comparator or use Comparable (natural order int the collection)
 */
public class ArrayBasics {
    public static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }

    static void reverseArrayToMap() {
        int[] nums = new int[]{8, 4, 3, 6, 1, 12, 23, 5};
        Map<Integer, Integer> num_index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            num_index.put(nums[i], i);
        }
        num_index.forEach((k, v) -> {
            System.out.println(k + ":  " + v);
        });


    }


    public static void main(String[] args) {
        reverseArrayToMap();
/*
        //Array constructor:
        int[][] arr = {{1, 2}, {3, 4}};

        Integer[] a = new Integer[10];
        Arrays.fill(a, 10);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        a[5] = 6;

        Integer min = Collections.min(Arrays.asList(a));
        System.out.println("min = " + min);

        List<Person> people = new ArrayList<>();
        people.add(new Person("tom", 23));
        people.add(new Person("tomYoung", 3));
        people.add(new Person("tomOld", 43));
        people.add(new Person("tomMedim", 33));

        Person minP = Collections.min(people, (p1, p2) -> {
            return p1.age - p2.age;
        });
        System.out.println("min model.Person= " + minP.name);

        Person maxP = Collections.max(people);
        System.out.println("max model.Person= " + maxP.name);
        */

    }


}
