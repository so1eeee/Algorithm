import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int dfs(int x, int y, char team) {
		visited[x][y] = true;
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && map[nx][ny] == team)
					cnt += dfs(nx, ny, team);
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int whitePower = 0;
		int bluePower = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					char team = map[i][j];
					int cnt = dfs(i, j, team);
					int power = cnt * cnt;
					if (team == 'W') {
						whitePower += power;
					} else {
						bluePower += power;
					}
				}
			}
		}
		System.out.println(whitePower + " " + bluePower);
	}
}