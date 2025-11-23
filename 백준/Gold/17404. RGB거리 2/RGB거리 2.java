import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == i) {
					dp[0][j] = cost[0][j];
				} else {
					dp[0][j] = 1000 * 1000 + 5;
				}
			}
			for (int j = 1; j < N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
			}
			for (int j = 0; j < 3; j++) {
				if (j != i) {
					min = Math.min(min, dp[N - 1][j]);
				}
			}
		}
		System.out.println(min);
	}
}
