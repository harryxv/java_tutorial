import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class ExceptionTypes {
    //IOException, a sub class of Exception, is a checked exception. it is subject to Catch or Specify requirement
    static void checkIOException() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("testIOExceptionFile.txt");
        pw.write("Tom and Jerry are good friends.");
        pw.close();
    }

    //List.get() throws IndexOutOfBoundsException, an unchecked exception. not subject to Catch or Specify requirement
    static void checkIndexOutOfBoundsException() {
        Integer[] arr = new Integer[10];
        Arrays.fill(arr, 1);
        List<Integer> intList = Arrays.asList(arr);
        System.out.println(intList.size());
        for (int i = 0; i <= 10; i++) {
            System.out.println(intList.get(i));
        }
    }

    public static void main(String[] args) {
        try {
            checkIOException();
            return;
            //checkIndexOutOfBoundsException();
        } catch (FileNotFoundException | IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("run statement in finally block");
        }
    }
}
