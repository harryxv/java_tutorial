import java.util.LinkedList;
import java.util.List;

public class StreamAPI {
    List<Person> roster = new LinkedList<>();

    public void addPeople(String[][] people) {
        for (String[] person : people) {
            addPerson(person[0], person[1], Integer.parseInt(person[2]));
        }
    }

    public void addPerson(String name, String gender, int age) {
        Person.Sex sex = Person.Sex.valueOf(gender);
        roster.add(new Person(name, sex, age));
    }

    //list Male person from roster, test filter aggregate operator
    public void printMale() {
        roster.stream().filter(e ->
                e.getGender() == Person.Sex.MALE
        ).forEach(e -> System.out.println(e.getName()));
    }

    public void printAverageAge() {
        roster.stream()
                .filter(e ->
                        e.getGender() == Person.Sex.MALE
                ).forEach(e -> System.out.println(e.getName()));
    }


    public static void main(String[] args) {
        StreamAPI rosterHandler = new StreamAPI();
        String[][] people = {{"Tom", Person.Sex.MALE.name(), "34"}, {"Jerry", Person.Sex.MALE.name(), "44"}, {"Mulan", Person.Sex.FEMALE.name(), "23"}};
        rosterHandler.addPeople(people);
        rosterHandler.printMale();
    }
}