import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] time;

	static int bfs(int start, int end) {
		if (start == end) {
			return 0;
		}
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		time[start] = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == end){
				return time[cur];
			}
			int nextPos = cur * 2;
			if (nextPos >= 0 && nextPos < 100001 && time[nextPos] == -1) {
				time[nextPos] = time[cur];
				queue.addFirst(nextPos);
			}
			int[] next = {cur - 1, cur + 1};
			for (int n : next) {
				if (n >= 0 && n < 100001 && time[n] == -1) {
					time[n] = time[cur] + 1;
					queue.addLast(n);
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
		time = new int[100001];
		Arrays.fill(time, -1);
		System.out.println(bfs(N, K));
	}
}
