import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cost = new int[N + 1];
		int[] ppl = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			ppl[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[C + 105];
		Arrays.fill(dp, 1100 * 100 + 5);
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			int curCost = cost[i];
			int curPeople = ppl[i];
			for (int j = curPeople; j < dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j - curPeople] + curCost);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = C; i < dp.length; i++) {
			min = Math.min(min, dp[i]);
		}
		System.out.println(min);
	}
}
