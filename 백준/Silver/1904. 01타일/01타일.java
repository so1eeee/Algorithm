import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long num = 15_746;
		long[][] dp = new long[1_000_001][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		for (int j = 3; j <= N; j++) {
			dp[j][0] = (dp[j - 2][0] + dp[j - 2][1]) % num;
			dp[j][1] = (dp[j - 1][0] + dp[j - 1][1]) % num;
		}
		System.out.println((dp[N][0] + dp[N][1]) % num);
	}
}
