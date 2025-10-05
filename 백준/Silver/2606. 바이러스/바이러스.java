import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
	static int N, M;
	static int cnt;

    static int dfs(int v) {
        visited[v] = true;
		for(int neighbor: adj.get(v)) {
			if(!visited[neighbor]){
				cnt++;
				dfs(neighbor);
			}
		}
		return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList<>();
		visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
		cnt = 0;
		System.out.println(dfs(1));
    }
}
