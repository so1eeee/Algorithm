import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        for(int i = 1; i < n; i++){
            while(!deque.isEmpty() && prices[i] < prices[deque.peek()]){
                int j = deque.poll();
                answer[j] = i - j;
            }
            deque.offerFirst(i);
        }

        while(!deque.isEmpty()){
            int j = deque.poll();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}
