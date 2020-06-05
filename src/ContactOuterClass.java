/**
 * Illustrate Outer-Inner class concept
 * instance inner class is a member of outer class
 * static inner class is a static member of outer class, it provides a static context.
 */

public class ContactOuterClass {
    private String country;
    private String name;

    public ContactOuterClass(String name) {
        this.name = name;
    }

    class Address {
        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public void showContactInfo() {
            System.out.println(name + " " + street + " " + city);
        }
    }

    //it implies a static context
    static class Region {
        private String province;

        public Region(String province) {
            this.province = province;
        }

        //static class can not access outer instance member
        public void showContactInfo() {
            //System.out.println(country + " " + province);
        }
    }

    public static void main(String[] args) {
        //how to instantiate an instance inner class
        ContactOuterClass outerClass = new ContactOuterClass("John");
        ContactOuterClass.Address address = outerClass.new Address("glenway circle", "toronto");

        //how to instantiate an static inner class
        ContactOuterClass.Region region = new ContactOuterClass.Region("ON");
    }
}
