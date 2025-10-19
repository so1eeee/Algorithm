import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int combination(int M, int N){
		int[][] dp = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j){
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[M][N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(combination(M, N));
		}
	}
}
