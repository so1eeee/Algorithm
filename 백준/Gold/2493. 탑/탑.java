import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = N - 1; i >= 0; i--) {
			while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
				int idx = deque.pollLast();
				result[idx] = i + 1;
			}
			deque.offer(i);
		}
		while (!deque.isEmpty()) {
			result[deque.poll()] = 0;
		}
		for (int num : result) {
			System.out.print(num + " ");
		}
	}
}
