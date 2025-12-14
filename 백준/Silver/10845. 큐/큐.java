import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			if (str[0].equals("push")) {
				deque.offer(Integer.parseInt(str[1]));
			} else if (str[0].equals("pop")) {
				if (!deque.isEmpty()) {
					System.out.println(deque.poll());
				} else {
					System.out.println(-1);
				}
			} else if (str[0].equals("size")) {
				System.out.println(deque.size());
			} else if (str[0].equals("empty")) {
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (str[0].equals("front")) {
				if (!deque.isEmpty()) {
					System.out.println(deque.peek());
				} else {
					System.out.println(-1);
				}
			} else if (str[0].equals("back")) {
				if (!deque.isEmpty()) {
					System.out.println(deque.peekLast());
				} else {
					System.out.println(-1);
				}
			}
		}
	}
}
