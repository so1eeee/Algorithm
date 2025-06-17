import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    static class Point {
        int x, count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    static int bfs(int start, int end) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == end) {
                return cur.count;
            }
            for (int i : adjList[cur.x]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(new Point(i, cur.count + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adjList = new ArrayList[n + 1];
        int start = sc.nextInt();
        int end = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            adjList[s].add(e);
            adjList[e].add(s);
        }

        visited = new boolean[n + 1];
        int res = bfs(start, end);
        System.out.println(res);
    }
}
