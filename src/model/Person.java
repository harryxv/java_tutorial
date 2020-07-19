package model;

public class Person implements Comparable<Person> {
    public enum Sex {
        MALE, FEMALE;

        static void listAllSex() {
            for (Sex gender : Sex.values()) {
                System.out.println(gender);
            }
        }
    }

    String name;
    Sex gender;
    int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public Person() {
    }

    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

}
