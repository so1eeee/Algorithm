import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =  Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][][] dp  = new int[N][M][3];
		for (int j = 0; j < M; j++) {
			for (int dir = 0; dir < 3; dir++) {
				dp[0][j][dir] = map[0][j];
			}
		}
		int MAX = 1000;
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < M; c++) {
				int down1 = (c > 0) ? dp[r - 1][c - 1][1] : MAX;
				int downLeft1 = (c > 0) ? dp[r - 1][c - 1][2] : MAX;
				dp[r][c][0] = map[r][c] + Math.min(down1, downLeft1);
				int downRight2 = dp[r - 1][c][0];
				int downLeft2 = dp[r - 1][c][2];
				dp[r][c][1] = map[r][c] + Math.min(downRight2, downLeft2);
				int downRight3 = (c < M - 1) ? dp[r - 1][c + 1][0] : MAX;
				int down3 = (c < M - 1) ? dp[r - 1][c + 1][1] : MAX;
				dp[r][c][2] = map[r][c] + Math.min(downRight3, down3);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < M; j++) {
			for (int dir = 0; dir < 3; dir++) {
				min = Math.min(min, dp[N - 1][j][dir]);
			}
		}
		System.out.println(min);
	}
}
