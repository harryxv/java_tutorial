package algorithms.challenges;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Calculate Day after a period of time
 */
public class FutureDay {
    public String solution(String S, int K) throws Exception {
        if (S.isEmpty() || K < 0) {
            throw new Exception("parameter invalid");
        }
        Map<String, Integer> dayNum = new HashMap<>();
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        IntStream.range(0, 7).forEach(num -> {
            dayNum.put(daysOfWeek[num], num);
        });

        int dayIndex = dayNum.get(S);
        int finalDayIndex = (dayIndex + K) % 7;
        return daysOfWeek[finalDayIndex];
    }

    public static void main(String[] args) throws Exception {
        FutureDay futureDay = new FutureDay();
        String S = "Sat";
        int K = 21;
        String day = futureDay.solution(S, K);
        System.out.println(day);
    }
}
