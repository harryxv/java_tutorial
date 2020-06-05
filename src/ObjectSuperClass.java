/**
 * illustrate feature of Object class, the super class for all classes
 */

import java.util.HashSet;
import java.util.Set;

public class ObjectSuperClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectSuperClass(String name) {
        this.name = name;
    }


    //contract between equals and hashCode
    /*equals defines what does it mean if two objects equals.
    equal objects must have same hashCode integer value. which means if you override equals, most time you need to override hashCode method too
    the hashCode() method is important on hashMap and HashSet data structure.
     */


    @Override
    public int hashCode() {
        //return super.hashCode();
        return 1001;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
        //return true;
    }

    public static void main(String[] args) {
        ObjectSuperClass obj1 = new ObjectSuperClass("obj1");
        ObjectSuperClass obj2 = new ObjectSuperClass("obj2");
        System.out.println("obj1.equals(obj2) ==" + obj1.equals(obj2));
        System.out.println("obj1.hashCode() ==" + obj1.hashCode());
        System.out.println("obj2.hashCode() ==" + obj2.hashCode());
        Set<ObjectSuperClass> objSet = new HashSet<>(2);
        objSet.add(obj1);
        objSet.add(obj2);

        System.out.println("objSet.size() == " + objSet.size());
    }
}
