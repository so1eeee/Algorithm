import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Node>> adj;
	static int[] dist;

	static void dfs(int startNode) {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[]{startNode, 0});
		dist[startNode] = 0;
		while (!deque.isEmpty()) {
			int[] currentPair = deque.removeLast();
			int current = currentPair[0];
			int parent = currentPair[1];
			for (Node next : adj.get(current)) {
				if (next.v != parent) {
					dist[next.v] = dist[current] ^ next.w;
					deque.addLast(new int[]{next.v, current});
				}
			}
		}
	}

	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		dist = new int[N + 1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(u).add(new Node(v, w));
			adj.get(v).add(new Node(u, w));
		}
		dfs(1);
		Map<Integer, Long> counts = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			counts.put(dist[i], counts.getOrDefault(dist[i], 0L) + 1);
		}
		long pairs = 0;
		for (long cnt : counts.values()) {
			if (cnt >= 2) {
				pairs += cnt * (cnt - 1) / 2;
			}
		}
		System.out.println(pairs);
	}
}
