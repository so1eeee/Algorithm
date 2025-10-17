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

	static int bfs() {
		if (N == K) {
			return 0;
		}
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(N);
		time[N] = 0;
		while (!deque.isEmpty()) {
			int cur = deque.poll();
			if(cur == K){
				return time[cur];
			}
			int n1 = cur * 2;
			if (n1 >= 0 && n1 < 100001) {
				if(time[n1] > time[cur]){
					time[n1] = time[cur];
					deque.addFirst(n1);
				}
			}
			int n2 = cur - 1;
			if (n2 >= 0 && n2 < 100001) {
				if(time[n2] > time[cur] + 1){
					time[n2] = time[cur] + 1;
					deque.addLast(n2);
				}
			}
			int n3 = cur + 1;
			if (n3 >= 0 && n3 < 100001) {
				if(time[n3] > time[cur] + 1){
					time[n3] = time[cur] + 1;
					deque.addLast(n3);
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
		Arrays.fill(time, Integer.MAX_VALUE);
		System.out.println(bfs());
	}
}
