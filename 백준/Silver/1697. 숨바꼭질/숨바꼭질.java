import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[] visited;
	static int[] time;

	static int bfs(int start, int end) {
		if (start == end) {
			return 0;
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		time[start] = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int[] next = {cur - 1, cur + 1, cur * 2};
			for (int nextPos : next) {
				if (nextPos >= 0 && nextPos < 100001 && !visited[nextPos]) {
					if(nextPos == end) {
						return time[cur] + 1;
					}
					visited[nextPos] = true;
					time[nextPos] = time[cur] + 1;
					queue.add(nextPos);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		time = new int[100001];
		Arrays.fill(time, -1);
		System.out.println(bfs(N, K));
	}
}