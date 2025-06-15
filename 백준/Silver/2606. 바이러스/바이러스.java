import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : adjList[cur]) {
                if(!visited[i]) {
                    cnt++;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = 1;

        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            adjList[s].add(e);
            adjList[e].add(s);
        }

        visited = new boolean[n + 1];
        int res = bfs(start);
        System.out.println(res);
    }
}