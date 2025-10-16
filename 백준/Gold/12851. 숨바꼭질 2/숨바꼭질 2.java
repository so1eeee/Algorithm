import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[] visited;
	static int[] time;
	static int[] cnt;

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		visited[N] = true;
		time[N] = 0;
		cnt[N] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int[] next = {cur - 1, cur + 1, cur * 2};
			for (int nextPos : next) {
				if (nextPos >= 0 && nextPos < 100001) {
					if(!visited[nextPos]){
						visited[nextPos] = true;
						time[nextPos] = time[cur] + 1;
						cnt[nextPos] = cnt[cur];
						queue.add(nextPos);
					} else if(time[nextPos] == time[cur] + 1){
						cnt[nextPos] += cnt[cur];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100_001];
		time = new int[100_001];
		cnt = new int[100_001];
		bfs();
		System.out.println(time[K]);
		System.out.println(cnt[K]);
	}
}
