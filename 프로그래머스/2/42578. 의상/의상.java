import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(String[][] clothes) {
        int result = 1;
        
        HashMap<String, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        
        for(String[] cloth: clothes){
            String name = cloth[0];
            String type = cloth[1];
            hashMap1.put(name, type);
        }
        
        for (String value : hashMap1.values()){
            hashMap2.put(value, hashMap2.getOrDefault(value, 0) + 1);
        }
        
        for (Entry<String, Integer> entry : hashMap2.entrySet()) {
            result *= (entry.getValue() + 1); 
        }
        
        return result - 1;
    }
}   