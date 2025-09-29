import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] nums;
	static int cnt = 0;

	static void dfs(int idx, int curSum) {
		if (idx == N) {
			if (curSum == S) {
				cnt++;
			}
			return;
		}
		dfs(idx + 1, curSum + nums[idx]);
		dfs(idx + 1, curSum);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		if (S == 0) {
			cnt--;
		}
		System.out.println(cnt);
	}
}
