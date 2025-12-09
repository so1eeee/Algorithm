import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			while (!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
				int idx = deque.pollLast();
				result[idx] = arr[i];
			}
			deque.offer(i);
		}
		while (!deque.isEmpty()) {
			result[deque.poll()] = -1;
		}
		for (int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}
}
