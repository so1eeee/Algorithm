import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>(N);
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			max.offer(num);
			min.offer(max.poll());
			if (max.size() < min.size()) {
				max.offer(min.poll());
			}
			System.out.println(max.peek());
		}
	}
}
