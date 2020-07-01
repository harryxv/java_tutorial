import java.util.LinkedList;
import java.util.List;

public class Stream {

    public static class Person {
        public enum SEX {
            MALE, FEMALE
        }

        String name;
        SEX gender;

        public Person(String name, SEX gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public SEX getGender() {
            return gender;
        }
    }

    List<Person> roster = new LinkedList<>();

    public void addPerson(String name, String gender) {
        Person.SEX sex = Person.SEX.valueOf(gender);
        roster.add(new Person(name, sex));
    }

    public static void main(String[] args) {
        Stream rosterHandler = new Stream();
        String[][] people = {{"Tom", "MALE"}, {"Jerry", "MALE"}, {"Albert", "MALE"}, {"Mulan", "FEMALE"}};
        for (String[] person : people) {
            rosterHandler.addPerson(person[0], person[1]);
        }
        rosterHandler.roster.stream().filter(e ->
                e.gender == Person.SEX.MALE
        ).forEach(e -> System.out.println(e.getName()));
    }
}