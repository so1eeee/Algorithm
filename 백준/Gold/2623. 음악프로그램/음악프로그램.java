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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int previous = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt - 1; j++) {
				int cur = Integer.parseInt(st.nextToken());
				graph[previous].add(cur);
				arr[cur]++;
				previous = cur;
			}
		}
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 0) {
				queue.offer(i);
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			for (int next : graph[cur]) {
				arr[next]--;
				if (arr[next] == 0) {
					queue.offer(next);
				}
			}
		}
		if (result.size() != N) {
			System.out.println(0);
			return;
		}
		for (int num : result) {
			System.out.println(num);
		}
	}
}
