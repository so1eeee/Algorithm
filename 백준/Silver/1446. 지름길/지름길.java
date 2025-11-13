import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		ArrayList<Shortcut> shortcuts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if (end > D) {
				continue;
			}
			shortcuts.add(new Shortcut(start, end, dist));
		}

		int[] dp = new int[10001];
		for (int i = 0; i <= 10000; i++) {
			dp[i] = i;
		}
		for (int i = 1; i <= D; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			for (Shortcut sc : shortcuts) {
				if (sc.end == i){
					dp[i] = Math.min(dp[i], dp[sc.start] + sc.dist);
				}
			}
		}
		System.out.println(dp[D]);
	}

	static class Shortcut {
		int start;
		int end;
		int dist;

		public Shortcut(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}
}
