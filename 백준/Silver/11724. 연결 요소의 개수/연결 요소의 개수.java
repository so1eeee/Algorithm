import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] visited;

	static void dfs(int node) {
		visited[node] = true;
		for (int neighbor : adj.get(node)) {
			if (!visited[neighbor]) {
				dfs(neighbor);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
}
