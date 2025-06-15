import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toUpperCase();
        int[] ch = new int[26];
        int max = -1;
        int cnt = 0;
        char maxChar = ' ';
        for(char c : str.toCharArray()) {
            ch[c - 'A']++;
        }
        for(char c : str.toCharArray()) {
            if(ch[c - 'A'] > max) {
                max = ch[c - 'A'];
                maxChar = c;
            }
        }
        for(int i : ch) {
            if(i == max){
                cnt++;
            }
        }

        if(cnt == 1){
            System.out.println(maxChar);
        }
        else {
            System.out.println("?");
        }
    }
}
