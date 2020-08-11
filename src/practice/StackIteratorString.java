package practice;

import java.util.*;

//check the item order from an iterator of stack

/**
 * regular Stack class, the order of item from Iterator does NOT follow LIFO
 * the Deque data structure, it follows LIFO order
 */
public class StackIteratorString {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "thisisabook";
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

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
