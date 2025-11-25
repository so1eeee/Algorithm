import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long low = 1L;
		long high = 2147483647L;
		long result = 0;
		while (low <= high) {
			long mid = (low + high) / 2;
			if (ask(mid)) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(result);
	}

	static boolean ask(long mid) {
		long sum = 0;
		for (int i = 0; i < K; i++) {
			sum += (arr[i] / mid);
		}
		return sum >= N;
	}
}
