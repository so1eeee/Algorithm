import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long num = 1000000007;
		long[][][] dp = new long[N + 1][N + 1][N + 1];
		dp[1][1][1] = 1;
		for (int n = 2; n <= N; n++) {
			for (int l = 1; l <= n; l++) {
				for (int r = 1; r <= n; r++) {
					long t1 = dp[n - 1][l - 1][r];
					long t2 = dp[n - 1][l][r - 1];
					long t3 = dp[n - 1][l][r] * (n - 2);
					dp[n][l][r] = (t1 + t2 + t3) % num;
				}
			}
		}
		System.out.println(dp[N][L][R]);
	}
}
