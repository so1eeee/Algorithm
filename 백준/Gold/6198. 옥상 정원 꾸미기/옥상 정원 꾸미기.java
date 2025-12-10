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
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			while (!deque.isEmpty() && num >= deque.peekLast()) {
				deque.pollLast();
			}
			sum += deque.size();
			deque.offer(num);
		}
		System.out.println(sum);
	}
}
