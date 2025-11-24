import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int low = 1;
		int high = arr[N - 1] - arr[0];
		int result = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (ask(mid)) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(result);
	}

	static boolean ask(int mid) {
		int cnt = 1;
		int lastInstalledPos = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - lastInstalledPos >= mid) {
				cnt++;
				lastInstalledPos = arr[i];
			}
		}
		return cnt >= C;
	}
}
