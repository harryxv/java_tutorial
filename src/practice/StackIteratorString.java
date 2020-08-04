package practice;

import java.util.*;


public class StackIteratorString {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "thisisabook";
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

//test Stack
        for (Character character : stack) {
            System.out.print(character);
        }
        System.out.println();
        stack.forEach(System.out::print);
        System.out.println();
        Iterator<Character> iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
    }
}
