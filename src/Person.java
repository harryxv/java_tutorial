public class Person implements Comparable<Person>, ReadonlyPerson {
    public enum Sex {
        MALE, FEMALE;

        static void listAllSex() {
            for (Sex gender : Sex.values()) {
                System.out.println(gender);
            }
        }
    }


    private String name;
    private Sex gender;
    private int age;

    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Sex getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public Person() {
    }

    public ReadonlyPerson find(String name) {
        return null;
    }

}
