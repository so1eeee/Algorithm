import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long start;
	static int end;

	static class Node {
		long num;
		int cnt;

		public Node(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static int bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		HashSet<Long> visited = new HashSet<>();
		queue.add(new Node(start, 1));
		visited.add(start);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			long curNum = cur.num;
			int curCnt = cur.cnt;
			long n1 = curNum * 2;
			if (n1 == end) {
				return curCnt + 1;
			}
			if (n1 < end && !visited.contains(n1)) {
				visited.add(n1);
				queue.add(new Node(n1, curCnt + 1));
			}
			long n2 = curNum * 10 + 1;
			if (n2 == end) {
				return curCnt + 1;
			}
			if (n2 < end && !visited.contains(n2)) {
				visited.add(n2);
				queue.add(new Node(n2, curCnt + 1));
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}
}
