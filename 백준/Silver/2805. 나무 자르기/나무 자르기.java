import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long low = 1;
		long high = 1_000_000_000;
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
		for (int i = 0; i < N; i++) {
			if (arr[i] - mid > 0){
				sum += (arr[i] - mid);
			}
		}
		return sum >= M;
	}
}
