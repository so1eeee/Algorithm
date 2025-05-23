import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < commands.length; i++){
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];
            int[] tmp = new int[b - a + 1];
            for(int j = 0; j < tmp.length; j++){
                tmp[j] = array[a - 1];
                a++;
            }
            Arrays.sort(tmp);
            list.add(tmp[c - 1]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}