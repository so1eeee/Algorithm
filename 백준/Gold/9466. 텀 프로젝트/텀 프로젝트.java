import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static boolean[] finished;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				if (!finished[i]) {
					dfs(i);
				}
			}
			bw.write((n - cnt) + "\n");
		}
		bw.flush();
	}

	static void dfs(int start) {
		visited[start] = true;
		int next = arr[start];
		if (!visited[next]) {
			dfs(next);
		} else if (!finished[next]) {
			cnt++;
			for (int tmp = arr[next]; tmp != next; tmp = arr[tmp]) {
				cnt++;
			}
		}
		finished[start] = true;
	}
}
