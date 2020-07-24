package algorithms.challenges;

import java.util.*;

/**
 * given a string:
 * "hello how are hello test you really this is again hello how are you";
 * <p>
 * find the shortest distance
 */

/**
 * 1,create a list of WordPos objects, which contains (word, position) information.
 * 2,sort by word,
 * 3,traverse the list for same words, for each same word, calculate distance, keep track the shortest distance and the word.
 * 4.once found 1, return, otherwise return the shortest one
 */
public class ShortestDistRepeatWord {
    private static class WordPos implements Comparable<WordPos> {
        String word;
        int pos;

        public WordPos(String word, int pos) {
            this.word = word;
            this.pos = pos;
        }

        //sort by string
        @Override
        public int compareTo(WordPos o) {
            return this.word.compareTo(o.word);
        }
    }

    public static WordPos getShortestDist(String s) {
        //build list of word_with_pos objects and sort
        String[] words = s.split("\\s+");
        List<WordPos> allWordPos = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            allWordPos.add(new WordPos(words[i], i));
        }
        Collections.sort(allWordPos);

        //start tracking shortest dist word and the distance
        WordPos prevWordPos = allWordPos.get(0), curWordPos = null;
        int shortestDist = 1000;
        String shortestDistWord = prevWordPos.word;

        for (int i = 1; i < allWordPos.size(); i++) {
            curWordPos = allWordPos.get(i);
            if (curWordPos.word.equalsIgnoreCase(prevWordPos.word)) {
                int dist = curWordPos.pos - prevWordPos.pos;
                if (dist < shortestDist) {
                    shortestDist = dist;
                    shortestDistWord = curWordPos.word;
                }
            }
            prevWordPos = curWordPos;
        }
        return new WordPos(shortestDistWord, shortestDist);
    }

    public static void main(String[] args) {
        //String s = "this string contains repeat word this and repeat";
        String s = "hello how are hello test you really this is again hello how are you";
        WordPos shortest = getShortestDist(s);
        System.out.println(shortest.word + "   ---  " + shortest.pos);
    }
}
