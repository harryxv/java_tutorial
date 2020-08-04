public class SingltonClassClient {
    public static void main(String[] args) {
        SingletonClass obj = SingletonClass.getInstance();
        System.out.println(obj.getNum());
    }
}
