import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[n][3];
			dp[0][0] = 0;
			dp[0][1] = arr[0][0];
			dp[0][2] = arr[1][0];
			for (int j = 1; j < n; j++) {
				dp[j][0] = Math.max(dp[j - 1][0], Math.max(dp[j - 1][1], dp[j - 1][2]));
				dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + arr[0][j];
				dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + arr[1][j];
			}
			int max = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
			System.out.println(max);
		}
	}
}
