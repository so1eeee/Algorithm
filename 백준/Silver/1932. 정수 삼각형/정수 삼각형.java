import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][][] dp = new int[n][n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0][0] = arr[0][0];
		dp[0][0][1] = arr[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]) + arr[i][j];
				dp[i][j][1] = j > 0 ? Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j] : Math.max(dp[i - 1][j][0], dp[i - 1][j][1]) + arr[i][j];
			}
		}
		int max = 0;
		for (int j = 0; j < n; j++) {
			for (int dir = 0; dir < 2; dir++) {
				max = Math.max(max, dp[n - 1][j][dir]);
			}
		}
		System.out.println(max);
	}
}