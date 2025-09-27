import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
	static int[] dr = {0, 0, 0, 1, -1};
	static int[] dc = {0, 1, -1, 0, 0};
	static boolean[][][] visited;

	static class Robot {
		int r, c, dir, cnt;
		public Robot(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	static int bfs(Robot start, Robot end) {
		Queue<Robot> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start.r][start.c][start.dir] = true;
		while (!queue.isEmpty()) {
			Robot cur = queue.poll();
			if (cur.r == end.r && cur.c == end.c && cur.dir == end.dir) {
				return cur.cnt;
			}
			for (int k = 1; k <= 3; k++) {
				int nr = cur.r + dr[cur.dir] * k;
				int nc = cur.c + dc[cur.dir] * k;
				if (nr > 0 && nr <= M && nc > 0 && nc <= N && map[nr][nc] == 0) {
					if (!visited[nr][nc][cur.dir]) {
						visited[nr][nc][cur.dir] = true;
						queue.add(new Robot(nr, nc, cur.dir, cur.cnt + 1));
					}
				} else {
					break;
				}
			}
			for (int i = 1; i <= 4; i++) {
				if (cur.dir != i && getOpposite(cur.dir) != i) {
					if (!visited[cur.r][cur.c][i]) {
						visited[cur.r][cur.c][i] = true;
						queue.add(new Robot(cur.r, cur.c, i, cur.cnt + 1));
					}
				}
			}
		}
		return -1;
	}

	static int getOpposite(int dir) {
		if (dir == 1) return 2;
		if (dir == 2) return 1;
		if (dir == 3) return 4;
		if (dir == 4) return 3;
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M + 1][N + 1];
		visited = new boolean[M + 1][N + 1][5];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		Robot start = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		st = new StringTokenizer(br.readLine());
		Robot end = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		System.out.println(bfs(start, end));
	}
}
