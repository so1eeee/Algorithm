import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static class Point {
		int r, c, cnt, broken;
		public Point(int r, int c, int cnt, int broken) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.broken = broken;
		}
	}

	static int bfs() {
		Deque<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.r == N - 1 && cur.c == M - 1) {
				return cur.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0 && !visited[nr][nc][cur.broken]) {
						visited[nr][nc][cur.broken] = true;
						queue.addFirst(new Point(nr, nc, cur.cnt, cur.broken));
					}
					else if (map[nr][nc] == 1 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						queue.addLast(new Point(nr, nc, cur.cnt + 1, 1));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
