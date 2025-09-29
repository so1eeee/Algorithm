import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[] mr = {-1, 1, 0, 0};
	static int[] mc = {0, 0, -1, 1};
	static int[] hr = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hc = {-1, 1, -2, 2, -2, 2, -1, 1};

	static class Monkey {
		int r, c, kUsed, cnt;
		public Monkey(int r, int c, int kUsed, int cnt) {
			this.r = r;
			this.c = c;
			this.kUsed = kUsed;
			this.cnt = cnt;
		}
	}

	static int bfs() {
		Queue<Monkey> queue = new ArrayDeque<>();
		queue.add(new Monkey(0, 0, 0, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Monkey cur = queue.poll();
			if (cur.r == H - 1 && cur.c == W - 1) {
				return cur.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + mr[i];
				int nc = cur.c + mc[i];
				if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0) {
					if (!visited[nr][nc][cur.kUsed]) {
						visited[nr][nc][cur.kUsed] = true;
						queue.add(new Monkey(nr, nc, cur.kUsed, cur.cnt + 1));
					}
				}
			}
			if (cur.kUsed < K) {
				for (int i = 0; i < 8; i++) {
					int nr = cur.r + hr[i];
					int nc = cur.c + hc[i];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0) {
						if (!visited[nr][nc][cur.kUsed + 1]) {
							visited[nr][nc][cur.kUsed + 1] = true;
							queue.add(new Monkey(nr, nc, cur.kUsed + 1, cur.cnt + 1));
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
}
