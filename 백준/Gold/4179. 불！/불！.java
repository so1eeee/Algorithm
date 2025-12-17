import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int[][] fireTime;
	static boolean[][] visited;

	static Queue<Node> queue = new ArrayDeque<>();
	static Queue<Node> fireQueue = new ArrayDeque<>();

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Node {
		int x;
		int y;
		int time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static void bfsFire() {
		while (!fireQueue.isEmpty()) {
			Node cur = fireQueue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if (map[nx][ny] != '#' && fireTime[nx][ny] == -1) {
						fireTime[nx][ny] = cur.time + 1;
						fireQueue.offer(new Node(nx, ny, cur.time + 1));
					}
				}
			}
		}
	}

	static int bfs() {
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.x == 0 || cur.y == 0 || cur.x == R - 1 || cur.y == C - 1) {
				return cur.time + 1;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if (!visited[nx][ny] && map[nx][ny] != '#') {
						if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= cur.time + 1) {
							continue;
						}
						visited[nx][ny] = true;
						queue.offer(new Node(nx, ny, cur.time + 1));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		fireTime = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				fireTime[i][j] = -1;
				if (map[i][j] == 'J') {
					queue.offer(new Node(i, j, 0));
					visited[i][j] = true;
				} else if(map[i][j] == 'F') {
					fireQueue.offer(new Node(i, j, 0));
					fireTime[i][j] = 0;
				}
			}
		}
		bfsFire();
		int result = bfs();
		if (result == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}
}
