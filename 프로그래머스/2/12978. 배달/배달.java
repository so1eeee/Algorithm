import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static class Node{
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : road){
            adjList[edge[0]].add(new Node(edge[1], edge[2]));
            adjList[edge[1]].add(new Node(edge[0], edge[2]));
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.dest] < cur.cost)
                continue;
            for(Node next : adjList[cur.dest]){
                if(dist[next.dest] > cur.cost + next.cost){
                    dist[next.dest] = cur.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K)
                answer++;
        }
        return answer;
    }
}