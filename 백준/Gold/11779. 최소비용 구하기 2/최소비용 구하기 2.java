import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int dest;
		int cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u  = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v, w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] dist = new int[n + 1];
		int[] parent = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (dist[cur.dest] < cur.cost) {
				continue;
			}
			for (Node next : adjList[cur.dest]) {
				if(dist[next.dest] > dist[cur.dest] + next.cost) {
					dist[next.dest] = cur.cost + next.cost;
					parent[next.dest] = cur.dest;
					pq.add(new Node(next.dest, dist[next.dest]));
				}
			}
		}
		System.out.println(dist[end]);
		ArrayDeque<Integer> path = new ArrayDeque<>();
		int cur = end;
		while (cur != 0) {
			path.offer(cur);
			if (cur == start) {
				break;
			}
			cur = parent[cur];
		}
		System.out.println(path.size());
		while (!path.isEmpty()) {
			System.out.print(path.pollLast() + " ");
		}
	}
}
