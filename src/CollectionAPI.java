import model.Person;

import java.util.*;

public class CollectionAPI {
    public static void generic() {
        List<String> ls = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        objectList.add("one string");
        objectList.add(new Person());
        objectList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        generic();
    }
}
