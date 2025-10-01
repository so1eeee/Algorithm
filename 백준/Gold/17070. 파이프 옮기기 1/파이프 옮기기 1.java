import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][N][3];
		dp[0][1][0] = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 2; c < N; c++) {
				if (map[r][c] == 1) continue;
				dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];
				if (r > 0) {
					dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];
				}
				if (r > 0 && map[r - 1][c] == 0 && map[r][c - 1] == 0) {
					dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
				}
			}
		}
		int result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
		System.out.println(result);
	}
}
