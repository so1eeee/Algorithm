import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] daysToComplete = new int[progresses.length];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            int a = progresses[i];
            int b = speeds[i];
            int t = (100 - a + b - 1) / b;
            daysToComplete[i] = t;
        }
        
        int currentMaxDays = daysToComplete[0];
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            if (daysToComplete[i] <= currentMaxDays) {
                // 현재 기능이 이전 기능과 함께 배포될 수 있는 경우
                count++;
            } else {
                // 새로운 배포가 필요한 경우
                result.add(count);
                count = 1;
                currentMaxDays = daysToComplete[i];
            }
        }
        //마지막 배포 추가
        result.add(count);
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}