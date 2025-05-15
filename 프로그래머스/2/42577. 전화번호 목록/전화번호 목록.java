import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<>();
        for(String phone : phone_book){
            hashSet.add(phone);
        }
        for (String phone : phone_book) {
            hashSet.remove(phone);
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (hashSet.contains(prefix)) {
                    return false;
                }
            }
            hashSet.add(phone);
        }
        return true;
    }
}