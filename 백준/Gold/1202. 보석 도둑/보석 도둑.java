import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel {
	int m;
	int v;

	public Jewel(int m, int v) {
		this.m = m;
		this.v = v;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(m, v);
		}
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jewels, (j1, j2) -> {
			return j1.m - j2.m;
		});
		Arrays.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long total = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && jewels[idx].m <= arr[i]) {
				pq.offer(jewels[idx].v);
				idx++;
			}
			if (!pq.isEmpty()) {
				total += pq.poll();
			}
		}
		System.out.println(total);
	}
}
