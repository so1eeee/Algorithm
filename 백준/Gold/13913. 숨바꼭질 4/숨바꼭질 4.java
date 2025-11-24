import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] time;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100001];
		parent = new int[100001];
		Arrays.fill(time, -1);
		time[N] = 0;
		bfs();
		System.out.println(time[K]);
		Deque<Integer> deque = new ArrayDeque<>();
		int cur = K;
		deque.offer(cur);
		while (cur != N) {
			cur = parent[cur];
			deque.offer(cur);
		}
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == K) {
				return;
			}
			int[] next = {cur - 1, cur + 1, cur * 2};
			for (int nextPos : next) {
				if (nextPos >= 0 && nextPos < 100001) {
					if(time[nextPos] == -1) {
						time[nextPos] = time[cur] + 1;
						parent[nextPos] = cur;
						queue.offer(nextPos);
					}
				}
			}
		}
	}
}
