import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] preSum = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		preSum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			preSum[i] = preSum[i - 1] + arr[i];
		}
		int max = preSum[X - 1];
		int cnt = 1;
		for (int i = X; i < N; i++) {
			int cur = preSum[i] - preSum[i - X];
			if (cur > max) {
				max = cur;
				cnt = 1;
			} else if (cur == max) {
				cnt++;
			}
		}
		if (max == 0){
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(cnt);
	}
}
