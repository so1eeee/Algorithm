import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }
        if((nums.length / 2) >= hashSet.size())
            return hashSet.size();
        return nums.length / 2;
    }
}