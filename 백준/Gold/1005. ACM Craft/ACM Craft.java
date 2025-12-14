import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer>[] graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			int[] arr = new int[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph[X].add(Y);
				arr[Y]++;
			}
			int W = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if (arr[i] == 0) {
					queue.offer(i);
					dp[i] = time[i];
				}
			}
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph[cur]) {
					dp[next] = Math.max(dp[next], dp[cur] + time[next]);
					arr[next]--;
					if (arr[next] == 0) {
						queue.offer(next);
					}
				}
			}
			System.out.println(dp[W]);
		}
	}
}
