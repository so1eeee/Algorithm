import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		int total = 0;
		for (int num : arr) {
			int idx = 0;
			for (int number : deque) {
				if (number == num) {
					break;
				}
				idx++;
			}
			int lt = idx;
			int rt = deque.size() - idx;
			if (lt <= rt) {
				for (int i = 0; i < lt; i++) {
					deque.offer(deque.poll());
					total++;
				}
			} else {
				for (int i = 0; i < rt; i++) {
					deque.offerFirst(deque.pollLast());
					total++;
				}
			}
			deque.poll();
		}
		System.out.println(total);
	}
}
