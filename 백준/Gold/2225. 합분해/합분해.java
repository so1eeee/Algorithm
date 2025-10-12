import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long num = 1_000_000_000;
		long[][] dp = new long[K + 1][N + 1];
		for (int k = 0; k <= K; k++) {
			dp[k][0] = 1;
		}
		for (int k = 1; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % num;
			}
		}
		System.out.println(dp[K][N]);
	}
}
