import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static boolean isPossible(int diff) {
		for (int min = 0; min <= (200 - diff); min++) {
			int max = min + diff;
			if(map[0][0] >= min && map[0][0] <= max){
				if (bfs(min, max)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean bfs(int min, int max) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited = new boolean[n][n];
		queue.add(new int[] {0, 0});
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0];
			int c = cur[1];
			if (r == n - 1 && c == n - 1) {
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if (!visited[nr][nc]) {
						int val = map[nr][nc];
						if (val >= min && val <= max) {
							visited[nr][nc] = true;
							queue.add(new int[] {nr, nc});
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int low = 0;
		int high = 200;
		int result = 200;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (isPossible(mid)) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(result);
	}
}
