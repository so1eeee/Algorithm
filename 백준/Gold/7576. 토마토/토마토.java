import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] box;

	static int bfs(Queue<int[]> queue, int unripeCnt) {
		if (unripeCnt == 0) {
			return 0;
		}
		int maxDays = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int days = current[2];
			maxDays = Math.max(maxDays, days);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
					box[nx][ny] = 1;
					unripeCnt--;
					queue.add(new int[]{nx, ny, days + 1});
				}
			}
		}
		if (unripeCnt > 0) {
			return -1;
		}
		return maxDays;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		int unripeCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new int[]{i, j, 0});
				} else if (box[i][j] == 0) {
					unripeCnt++;
				}
			}
		}
		int result = bfs(queue, unripeCnt);
		System.out.println(result);
	}
}
