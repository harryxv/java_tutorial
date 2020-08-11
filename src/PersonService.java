public class PersonService {
    public static void main(String[] args) {
        Person p = new Person();

        ReadonlyPerson person = p.find("John");
        
    }
}
