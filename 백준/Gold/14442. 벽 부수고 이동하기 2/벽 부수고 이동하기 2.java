import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static class Point {
		int r, c, dist, cnt;
		public Point(int r, int c, int dist, int cnt) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.cnt = cnt;
		}
	}

	static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.r == N - 1 && cur.c == M - 1) {
				return cur.dist;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0 && !visited[nr][nc][cur.cnt]) {
						visited[nr][nc][cur.cnt] = true;
						queue.add(new Point(nr, nc, cur.dist + 1, cur.cnt));
					}
					else if (map[nr][nc] == 1 && cur.cnt < K && !visited[nr][nc][cur.cnt + 1]) {
						visited[nr][nc][cur.cnt + 1] = true;
						queue.add(new Point(nr, nc, cur.dist + 1, cur.cnt + 1));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
