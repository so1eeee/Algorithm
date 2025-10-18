
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[k + 1][n + 1];
			for (int j = 1; j <= n; j++) {
				dp[0][j] = j;
			}
			for (int j = 1; j <= k; j++) {
				for (int l = 1; l <= n; l++) {
					for (int m = 1; m <= l; m++) {
						dp[j][l] += dp[j - 1][m];
					}
				}
			}
			System.out.println(dp[k][n]);
		}
	}
}
