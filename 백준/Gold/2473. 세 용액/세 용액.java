import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long[] result = new long[3];
		for (int i = 0; i < N - 2; i++) {
			int lt = i + 1;
			int rt = N - 1;
			while (lt < rt) {
				long sum = arr[i] + arr[lt] + arr[rt];
				long absSum = Math.abs(sum);
				if (absSum < min) {
					min = absSum;
					result[0] = arr[i];
					result[1] = arr[lt];
					result[2] = arr[rt];
				}
				if (sum > 0) {
					rt--;
				} else if (sum < 0) {
					lt++;
				} else {
					break;
				}
			}
		}
		System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}
}
