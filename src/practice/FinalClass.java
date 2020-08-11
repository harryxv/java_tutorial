package practice;

//check final keyword usage:
//final on class: class cannot be inherited
//final on method: method canNOT be overridden
//final on field: variable cannot be assigned to another primitive value or object reference
public final class FinalClass {
    public final static double PI = 3.14;

    public FinalClass() {
        //final class constructor
    }

    public static final void add() {

    }

    public final void addIns() {

    }
}
