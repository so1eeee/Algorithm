import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[][][] box;

	static class Point {
		int x, y, z;
		int days;

		public Point(int x, int y, int z, int days) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.days = days;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		int cnt = 0;
		Queue<Point> q = new ArrayDeque<>();
		for(int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if (box[k][i][j] == 1) {
						q.offer(new Point(i, j, k, 0));
					} else if (box[k][i][j] == 0) {
						cnt++;
					}
				}
			}
		}
		System.out.println(bfs(q, cnt));
	}

	static int bfs(Queue<Point> q, int cnt) {
		if (cnt == 0) {
			return 0;
		}
		int maxDays = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			maxDays = cur.days;
			for (int i = 0; i < 6; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nz = cur.z + dz[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					if (box[nz][nx][ny] == 0) {
						box[nz][nx][ny] = 1;
						cnt--;
						q.add(new Point(nx, ny, nz, cur.days + 1));
					}
				}
			}
		}
		if (cnt > 0) {
			return -1;
		}
		return maxDays;
	}
}
