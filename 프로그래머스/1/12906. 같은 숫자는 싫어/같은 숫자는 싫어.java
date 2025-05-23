import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int num : arr){
            if(!deque.isEmpty() && deque.peekLast() == num){
                continue;
            }
            deque.offerLast(num);
        }
        int[] answer = new int[deque.size()];
        int i = 0;
        for(int num : deque){
            answer[i++] = num;
        }

        return answer;
    }
}