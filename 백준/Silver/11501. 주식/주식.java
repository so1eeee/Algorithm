import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int max = 0;
			long profit = 0;
			for (int i = 0; i < N; i++) {
				arr[i] =  Integer.parseInt(st.nextToken());
			}
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				} else {
					profit += max - arr[i];
				}
			}
			System.out.println(profit);
		}
	}
}
