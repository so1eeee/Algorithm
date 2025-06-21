import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int i = 0, j = n - 1, cnt = 0;

        for (int k = 0; k < n; k++) {
            arr[k] = sc.nextInt();
        }

        Arrays.sort(arr);

        while (i < j) {
            if(arr[i] + arr[j] < m)
                i++;
            else if(arr[i] + arr[j] > m)
                j--;
            else{
                cnt++;
                i++;
                j--;
            }
        }
        System.out.println(cnt);
    }
}
