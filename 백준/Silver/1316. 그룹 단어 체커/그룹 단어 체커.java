import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int cnt = 0;
        for(int i = 0; i < N; i++){
            String word = sc.nextLine();
            if(isGroupedWord(word)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isGroupedWord(String word) {
        boolean[] seen = new boolean[26];
        char tmp = 'A';
        for(char c : word.toCharArray()){
            if(c != tmp){
                if(seen[c - 'a']){
                    return false;
                }
                seen[c - 'a'] = true;
            }
            tmp = c;
        }
        return true;
    }
}
