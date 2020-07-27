package util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class DequeAsStack {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<String>();
        IntStream.range(1, 10).forEach(
                e -> stack.push(e + "")
        );
        System.out.println(stack);
    }
}
