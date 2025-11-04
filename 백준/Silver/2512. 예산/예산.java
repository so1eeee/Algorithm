import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		int M = Integer.parseInt(br.readLine());
		if (sum <= M){
			System.out.println(max);
			return;
		}
		int low = 0;
		int high = max;
		int res = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			int cur = 0;
			for (int num : arr) {
				cur += Math.min(num, mid);
			}
			if (cur <= M) {
				res = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(res);
	}
}
