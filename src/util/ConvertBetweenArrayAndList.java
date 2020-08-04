package util;

import java.util.*;
import java.util.stream.IntStream;


//Arrays.asList();  from array to list
//toArray(new Array
public class ConvertBetweenArrayAndList {

    public static void convertStringToCharSet() {
        String s = "ABCDEFGHIJKLMN";
        Set<Character> charSet = new HashSet<>();
        IntStream.range(0, s.length()).forEach(c -> {
            charSet.add(s.charAt(c));
        });
        charSet.forEach(System.out::println);
    }

    public static void convertListToArray() {
        List<String> keywordList = new ArrayList<>();
        keywordList.add("Mon");
        keywordList.add("Tue");
        keywordList.add("Wed");

        //Important!!!, the toArray with new
        String[] array = new String[keywordList.size()];
        keywordList.toArray(array);

        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void main1(String[] args) {
        //

        String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        List<String> keywordList = Arrays.asList(keywords);
        String[] array = (String[]) keywordList.toArray();

        Set<String> strings = new HashSet(keywordList);
        keywordList.forEach(System.out::println);

        String[] newKeywords = keywordList.toArray(new String[keywordList.size()]);
        System.out.println(Arrays.toString(newKeywords));

        Set<String> keywordSet = new HashSet<>(keywordList);  //init a set using list
        Queue<String> keywordsQ = new LinkedList(keywordList);  // inti a Queue using a list
    }

    public static void main(String[] args) {
        convertStringToCharSet();
        convertListToArray();
    }
}
