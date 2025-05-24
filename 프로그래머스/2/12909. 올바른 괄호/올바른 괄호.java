import java.util.*;

class Solution {
    boolean solution(String s) {
        
        ArrayDeque<Character> deque = new ArrayDeque<>();
        
        char[] a = s.toCharArray();
        
        for(char c : a){
            if(c == '('){
                deque.offerFirst(c);
            }
            else{
                 if(deque.isEmpty()) {
                    return false;
                }
                deque.pollFirst();
            }
        }

        return deque.isEmpty();
    }
}