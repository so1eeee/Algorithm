import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;

    static class Point {
        int x, y, count;
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<Point> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new Point(startX, startY, 1));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == endX && p.y == endY) {
                return p.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.count + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        int res = bfs(0, 0, N - 1, M - 1);
        System.out.println(res);
    }
}
