import java.util.*;

class Solution {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static int N, M;
    static int[][] dist;
    static int[][] map;

    static class Point{
        int nx, ny;
        public Point(int nx, int ny){
            this.nx = nx;
            this.ny = ny;
        }
    }

    static int bfs(){
        ArrayDeque<Point> deque = new ArrayDeque<>();
        deque.offer(new Point(0, 0));
        dist[0][0] = 1;

        while(!deque.isEmpty()){
            Point now = deque.poll();

            for(int i = 0; i < 4; i++){
                int nextX = now.nx + dx[i];
                int nextY = now.ny + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || map[nextX][nextY] == 0)
                    continue;

                if(dist[nextX][nextY] == 0){
                    deque.offer(new Point(nextX, nextY));
                    dist[nextX][nextY] = dist[now.nx][now.ny] + 1;
                }
            }
        }
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        dist = new int[N][M];
        map = maps;
        return bfs();
    }
}

