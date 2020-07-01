import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Arrays.fill() api.
 * <p>
 * Collections.min() api, make your code concise. with Comparator or use Comparable (natural order int the collection)
 */
public class ArrayBasics {
    public static void main(String[] args) {
        Integer[] a = (Integer[]) Array.newInstance(Integer.class, 10);
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
        System.out.println("min Person= " + minP.name);

        Person maxP = Collections.max(people);
        System.out.println("max Person= " + maxP.name);

    }

    static class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
    }
}
