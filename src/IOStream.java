import java.io.*;
import java.util.Scanner;

public class IOStream {
    private static final String projectPath = System.getProperty("user.dir");  ///Users/hxu/Tutorials/java-tutorial
    private static final String resources = "/resources";

    //handle I/O of raw binary data.
    //InputString/OutputStream lets developer handle IO of one byte a time.
    //FileInputStream and FileOutputStream are descendents of InputStream and OutputStream
    //because read byte by byte each loop is too expensive, we normally use bufferedInputStream/BufferedOutputStream to perform task
    public void copyBytes() throws IOException {

        try (FileInputStream in = new FileInputStream(projectPath + "/" + resources + "/" + "testcontent.txt");
             BufferedInputStream bis = new BufferedInputStream(in);
             FileOutputStream out = new FileOutputStream(projectPath + "/" + resources + "/" + "testcontent_copy.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out);
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        }
    }


    /**
     * handle I/O of character, using default encoding.
     * Reader/Writer --> FileReader/FileWriter
     * use BufferedReader, and BufferWriter to perform task for high-efficiency
     */
    public void copyCharacter() throws IOException {
        try (FileReader in = new FileReader(projectPath + "/" + resources + "/testcontent.txt");
             BufferedReader br = new BufferedReader(in);
             FileWriter out = new FileWriter(projectPath + "/" + resources + "/testcontent_copy.txt");
             BufferedWriter bw = new BufferedWriter(out);
        ) {
            int c;
            while ((c = br.read()) != -1) {
                bw.write(c);
            }
        }
    }

    /**
     * handle I/O of character: subclass of Reader and Writer -> FileReader, FileWriter
     * buffered reader, and buffered formatted writer. -> BufferedReader, PrintWriter
     * this class allows println() methods. PrintWriter has constructor, PrintWriter(String filePath);
     */
    public void copyLines() throws IOException {
        try (FileReader in = new FileReader(projectPath + "/" + resources + "/testcontent.txt");
             BufferedReader br = new BufferedReader(in);
             FileWriter out = new FileWriter(projectPath + "/" + resources + "/testcontent_copy.txt");
             PrintWriter pw = new PrintWriter(out);
        ) {
            String l;
            while ((l = br.readLine()) != null) {
                pw.println(l);
            }
        }
    }


    public void scanToken() {
        String s = "it is time to start learning golang";
        Scanner scanner = new Scanner(s);
        scanner.tokens().forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        IOStream io = new IOStream();
        io.scanToken();

        try {
            io.copyBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            io.copyCharacter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            io.copyLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
