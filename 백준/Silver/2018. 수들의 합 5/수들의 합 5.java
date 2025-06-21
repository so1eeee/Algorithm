import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int j, sum = 0, cnt = 0;
        for (int i = 1; i <= n / 2; i++) {
            j = i;
            while(sum < n){
                sum += j;
                if (sum == n) {
                    cnt++;
                }
                j++;
            }
            sum = 0;
        }
        System.out.println(cnt + 1);
    }
}
