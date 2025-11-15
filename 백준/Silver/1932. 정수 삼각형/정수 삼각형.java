import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + arr[i][0];
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			}
			dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
		}
		int max = 0;
		for (int j = 0; j < n; j++) {
			max = Math.max(max, dp[n - 1][j]);
		}
		System.out.println(max);
	}
}
