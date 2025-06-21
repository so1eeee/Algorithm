import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] res = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            res[i] = sum;
        }
        for (int i = 0; i < m; i++) {
            int a, b, ans;
            a = sc.nextInt();
            b = sc.nextInt();
            ans = res[b] - res[a - 1];
            System.out.println(ans);
        }
    }
}