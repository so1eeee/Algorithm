import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
        int idx;
        int priority;

        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Deque<Node> deque = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				deque.offer(new Node(j, priority));
				pq.offer(priority);
			}
			int cnt = 1;
			while (!deque.isEmpty()) {
				Node cur = deque.peek();
				if (!pq.isEmpty() && cur.priority < pq.peek()) {
					deque.offer(deque.poll());
				} else if (!pq.isEmpty() && cur.priority == pq.peek()) {
					if (cur.idx == M) {
						System.out.println(cnt);
						break;
					}
					pq.poll();
					deque.poll();
					cnt++;
				}
			}
		}
    }
}
