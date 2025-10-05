import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] cnt;
	static int N, M;
	static boolean[] visited;

	static int bfs(Map<Integer, Integer> map) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == 100){
				return cnt[100];
			}
			for (int i = 1; i <= 6; i++) {
				int next = cur + i;
				if(next > 100)
					continue;
				if(map.containsKey(next)) {
					next = map.get(next);
				}
				if(!visited[next]) {
					visited[next] = true;
					cnt[next] = cnt[cur] + 1;
					queue.add(next);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cnt = new int[101];
		visited = new boolean[101];
		Map<Integer, Integer> move = new HashMap<>();
		for (int i = 0; i < N + M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			move.put(from, to);
		}
		cnt[1] = 0;
		System.out.println(bfs(move));
	}
}
