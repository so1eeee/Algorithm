import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n + 1);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (i >= 2){
				dp[i] = Math.min(dp[i], dp[i - 2] + 1);
			}
			if (i >= 5){
				dp[i]  = Math.min(dp[i], dp[i - 5] + 1);
			}
		}
		if (dp[n] == n + 1) {
			System.out.println(-1);
		} else {
			System.out.println(dp[n]);
		}
	}
}
