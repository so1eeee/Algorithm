import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int startX;
	static int startY;
	static int[][] arr;
	static int[][] res;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };


	static class Point {
		int x;
		int y;
		int dist;
		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(startX, startY, 0));
		visited[startX][startY] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx =  p.x + dx[i];
				int ny =  p.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (!visited[nx][ny] && arr[nx][ny] == 1) {
						res[nx][ny] = p.dist + 1;
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny, p.dist + 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		res = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					startX = i;
					startY = j;
					res[i][j] = 0;
				} else if (arr[i][j] == 1) {
					res[i][j] = -1;
				}
			}
		}
		bfs();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
