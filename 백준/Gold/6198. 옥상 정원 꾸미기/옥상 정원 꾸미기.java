import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		Arrays.fill(result, N);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
				int idx = deque.pollLast();
				result[idx] = i;
			}
			deque.offer(i);
		}
		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (result[i] - i - 1);
		}
		System.out.println(sum);
	}
}
