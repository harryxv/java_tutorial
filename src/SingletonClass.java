public class SingletonClass {
    private int num = 0;
    private static SingletonClass instance = new SingletonClass();

    public int getNum() {
        return num;
    }

    private SingletonClass() {
        //
    }

    public static SingletonClass getInstance() {
        return instance;
    }

}
