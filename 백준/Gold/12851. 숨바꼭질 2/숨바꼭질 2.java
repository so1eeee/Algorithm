import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] time;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100_001];
		cnt = new int[100_001];
		Arrays.fill(time, -1);
		time[N] = 0;
		cnt[N] = 1;
		if(N >= K){
			System.out.println(N - K);
			System.out.println(1);
			return;
		}
		bfs();
		System.out.println(time[K]);
		System.out.println(cnt[K]);
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
					if(time[nextPos] == -1){
						time[nextPos] = time[cur] + 1;
						cnt[nextPos] = cnt[cur];
						queue.offer(nextPos);
					} else if(time[nextPos] == time[cur] + 1){
						cnt[nextPos] += cnt[cur];
					}
				}
			}
		}
	}
}
