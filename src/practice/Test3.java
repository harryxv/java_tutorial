package practice;
import java.util.*;
public class Test3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> dupCheck = new HashSet<>();
        List<Integer> list = new LinkedList<>();

        int nextIndex= A[0];
        list.add(0);
        dupCheck.add(nextIndex);
        while(nextIndex !=-1){
            list.add(nextIndex);
            nextIndex = A[nextIndex];
            if(dupCheck.contains(nextIndex)){
                System.out.println("cycle error");
                return -1;
            }
            dupCheck.add(nextIndex);
        }
        return list.size();
    }

    public static void main(String[] args) {
        Test3 t= new Test3();
        int[] A = {1,5,3,2,-1,3};
       System.out.println( t.solution(A));
    }
}
