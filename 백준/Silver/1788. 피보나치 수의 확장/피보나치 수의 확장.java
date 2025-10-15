import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long num = 1_000_000_000;
		if (n == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		int N = Math.abs(n);
		long[] dp = new long[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % num;
		}
		if (n > 0) {
			System.out.println(1);
		} else {
			if (N % 2 == 0) {
				System.out.println(-1);
			} else {
				System.out.println(1);
			}
		}
		System.out.println(dp[N]);
	}
}
