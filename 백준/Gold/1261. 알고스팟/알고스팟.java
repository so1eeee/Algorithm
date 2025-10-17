import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int bfs() {
		Deque<Point> deque = new ArrayDeque<>();
		deque.add(new Point(0, 0));
		dist[0][0] = 0;
		while (!deque.isEmpty()) {
			Point cur = deque.poll();
			if (cur.r == N - 1 && cur.c == M - 1) {
				return dist[cur.r][cur.c];
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(dist[nr][nc] > dist[cur.r][cur.c] + map[nr][nc]){
						dist[nr][nc] = dist[cur.r][cur.c] + map[nr][nc];
						if (map[nr][nc] == 0) {
							deque.addFirst(new Point(nr, nc));
						} else {
							deque.addLast(new Point(nr, nc));
						}
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
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
}
