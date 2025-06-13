import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 1){
            System.out.println(1);
            return;
        }
        int cnt = 1;
        int max = 0;
        while(max < N){
            cnt++;
            max = 1 + 3 * cnt * (cnt - 1);
        }
        System.out.println(cnt);
    }
}
