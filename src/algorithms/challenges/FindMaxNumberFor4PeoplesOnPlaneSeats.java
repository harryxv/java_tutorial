package algorithms.challenges;

import java.util.*;
import java.util.stream.IntStream;

public class FindMaxNumberFor4PeoplesOnPlaneSeats {
    public int solution(int N, String S) {
        if (S.isEmpty()) {
            return 2 * N;
        }
        //skip corner case check based on assumption
        Set<Character> fullSeats = new LinkedHashSet();
        String fullSeatsString = "ABCDEFGHJK";

        for (char c : fullSeatsString.toCharArray()) {
            fullSeats.add(c);
        }

        int avaiNum = 0;
        //distribute occupied seat to row-based map, use Map data structure
        Map<Integer, Set<Character>> occupSeats = new HashMap<>();
        IntStream.range(1, N + 1).forEach((num -> {
            occupSeats.put(num, new LinkedHashSet<>());
        }));
        String[] takenSeats = S.split("\\s");
        for (String seat : takenSeats) {
            int seatRow = Integer.parseInt(seat.substring(0, seat.length() - 1));
            Character seatChar = seat.charAt(seat.length() - 1);
            occupSeats.get(seatRow).add(seatChar);
        }

        //go through each, find available seats and check whether they are available for 4-person
        for (int i = 1; i < N + 1; i++) {
            Set<Character> rowOccupSeats = occupSeats.get(i);
            if (rowOccupSeats.size() > 6) {//check remain seats number
                continue;
            }
            if (rowOccupSeats.isEmpty()) {//no occupy, max seats available
                avaiNum = avaiNum + 2;
                continue;
            }
            Set<Character> rowFullSeats = new LinkedHashSet();
            rowFullSeats.addAll(fullSeats);
            rowFullSeats.removeAll(rowOccupSeats);
            StringBuilder rowSeatsString = combineChar(rowFullSeats);
            if (rowSeatsString.indexOf("BCDE") > -1) {//
                avaiNum++;
                if (rowSeatsString.indexOf("FGHJ") > -1) {
                    avaiNum++;
                }
            } else {
                if (rowSeatsString.indexOf("DEFG") > -1) {
                    avaiNum++;
                } else if (rowSeatsString.indexOf("FGHJ") > -1) {
                    avaiNum++;
                }
            }
        }
        return avaiNum;
    }

    private StringBuilder combineChar(Set<Character> rowFullSeats) {
        StringBuilder s = new StringBuilder();
        for (Character c : rowFullSeats) {
            s.append(c);
        }
        return s;
    }

    public static void main(String[] args) {
        FindMaxNumberFor4PeoplesOnPlaneSeats client = new FindMaxNumberFor4PeoplesOnPlaneSeats();
        int num = client.solution(2, "");
        System.out.println(num);
    }
}
