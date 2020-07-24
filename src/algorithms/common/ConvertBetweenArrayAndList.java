package algorithms.common;

import java.util.*;
//bridge methods between array-based and collection-based APIs.
/**
 * Arrays class's asList(array) convert an array into a List,
 * this API is very useful for converting array to collection-based APIs for processing.
 * the generated list can be used to fill other collection datatype's constructor, for example:
 * Set, Queue
 */

//Arrays.asList() API  convert Array to List
//list.toArray(T[] t)
public class ConvertBetweenArrayAndList {
    public static void main(String[] args) {
        String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        List<String> keywordList = Arrays.asList(keywords);
        Set<String> strings = new HashSet(keywordList);
        keywordList.forEach(System.out::println);

        String[] newKeywords= keywordList.toArray(new String[keywordList.size()]);
        System.out.println(Arrays.toString(newKeywords));

        Set<String> keywordSet = new HashSet<>(keywordList);  //init a set using list
        Queue<String> keywordsQ= new LinkedList(keywordList);  // inti a Queue using a list
    }
}
