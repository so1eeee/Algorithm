import java.util.ArrayDeque;

class Solution {
    public int solution(String s){
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!deque.isEmpty() && deque.peek() == c){
                deque.poll();
            }
            else {
                deque.offerFirst(c);
            }
        }
        return deque.isEmpty() ? 1 : 0;
    }
}
