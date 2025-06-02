import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < N; i++){
            int[] frequency = new int[26];
            int maxFrequency = 0;
            String text = sc.nextLine();
            char result = '?';
            for(char c : text.toCharArray()){
                if(c >= 'a' && c <= 'z'){
                    frequency[c - 'a']++;
                    if(frequency[c - 'a'] > maxFrequency){
                        maxFrequency = frequency[c - 'a'];
                        result = c;
                    } else if (frequency[c - 'a'] == maxFrequency){
                        result = '?';
                    }
                }
            }
            System.out.println(result);
        }
    }
}
