import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		int start = 1;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num >= start) {
				while (num >= start) {
					deque.offer(start);
					start++;
					sb.append("+\n");
				}
			}
			if (!deque.isEmpty() && deque.peekLast() != num) {
				System.out.println("NO");
				return;
			}
			deque.pollLast();
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}
