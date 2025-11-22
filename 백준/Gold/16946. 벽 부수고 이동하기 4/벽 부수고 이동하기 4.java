import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] groupMap;
	static Map<Integer, Integer> groupSizeMap;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int bfs(int r, int c, int groupId) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(r, c));
		groupMap[r][c] = groupId;
		int cnt = 1;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 0 && groupMap[nr][nc] == 0) {
						groupMap[nr][nc] = groupId;
						queue.add(new Point(nr, nc));
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		groupMap = new int[N][M];
		groupSizeMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		int groupId = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && groupMap[i][j] == 0) {
					int size = bfs(i, j, groupId);
					groupSizeMap.put(groupId, size);
					groupId++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					sb.append(0);
				} else {
					int sum = 1;
					Set<Integer> adj = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
							if (map[nr][nc] == 0) {
								adj.add(groupMap[nr][nc]);
							}
						}
					}
					for (int id : adj) {
						sum += groupSizeMap.get(id);
					}
					sb.append(sum % 10);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
