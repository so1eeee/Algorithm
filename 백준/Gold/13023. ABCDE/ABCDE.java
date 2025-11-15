import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static boolean found = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
			if (found) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	static void dfs(int node, int depth) {
		if (found) {
			return;
		}
		if (depth == 4) {
			found = true;
			return;
		}
		visited[node] = true;
		for (int neighbor : adj[node]) {
			if (!visited[neighbor]) {
				dfs(neighbor, depth + 1);
			}
			if (found){
				return;
			}
		}
		visited[node] = false;
	}
}
