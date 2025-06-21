import java.util.*;

public class Main {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

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

        for (int i = 1; i <= n ; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[n + 1];
        dfs(start);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int now) {
        System.out.print(now + " ");
        visited[now] = true;
        for (int i : adjList[now]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int i : adjList[cur]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
