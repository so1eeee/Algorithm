import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int K = Integer.parseInt(br.readLine());
		long low = 1;
		long high = N * N;
		long result = 0;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			long count = 0;
			for (int i = 1; i <= N; i++) {
				count += Math.min(N, (mid / i));
			}
			if (count >= K) {
				result = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		System.out.println(result);
	}
}
