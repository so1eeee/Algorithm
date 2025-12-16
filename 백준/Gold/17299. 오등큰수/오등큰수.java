import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
		}
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			while (!deque.isEmpty() && hashMap.get(arr[deque.peekLast()]) < hashMap.get(arr[i])) {
				result[deque.pollLast()] = arr[i];
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
