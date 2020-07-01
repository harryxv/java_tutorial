import java.util.stream.IntStream;

class JavaStream {
    public static void main(String[] args) {
        System.out.println("JavaStream tutorialsF");
        printIntStream();
    }

    static void printIntStream() {
        IntStream intStream = IntStream.range(0, 10);
        /*
         * intStream.forEach((e)->{ System.out.println(e); });
         */
        intStream.forEach(System.out::println);
    }
}