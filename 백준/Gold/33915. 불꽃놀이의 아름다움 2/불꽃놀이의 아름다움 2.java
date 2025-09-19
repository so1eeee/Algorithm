import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> adj;
	static int[] colors;
	static boolean[] visited;
	static boolean isPossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		colors = new int[N + 1];
		visited = new boolean[N + 1];
		isPossible = true;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		if (dfs(1)) System.out.println(2);
		else System.out.println(3);
	}

	public static boolean dfs(int start) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.addLast(start);
		visited[start] = true;
		colors[start] = 1;
		while (!deque.isEmpty()) {
			int node = deque.removeLast();
			for (int neighbor : adj.get(node)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					colors[neighbor] = 3 - colors[node];
					deque.addLast(neighbor);
				} else if (colors[neighbor] == colors[node]) {
					return false;
				}
			}
		}
		return true;
	}
}
