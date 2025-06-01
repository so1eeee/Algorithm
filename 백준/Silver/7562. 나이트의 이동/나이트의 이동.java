import java.util.*;

public class Main {
    static int l;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Point {
        int x, y, count;
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<Point> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new Point(startX, startY, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == endX && p.y == endY) {
                return p.count;
            }

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.count + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            l = sc.nextInt();
            board = new int[l][l];
            visited = new boolean[l][l];

            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            System.out.println(bfs(startX, startY, endX, endY));
        }

        sc.close();
    }
}