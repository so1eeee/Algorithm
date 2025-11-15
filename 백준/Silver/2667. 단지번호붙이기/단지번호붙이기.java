import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		int cnt = 1;
		while(!q.isEmpty()){
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N){
					if(map[nx][ny] == 1 && !visited[nx][ny]){
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++){
			String line = br.readLine();
			for(int j = 0; j < N; j++){
				map[i][j] = line.charAt(j) - '0';
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]){
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int cnt : list) {
			System.out.println(cnt);
		}
	}
}
