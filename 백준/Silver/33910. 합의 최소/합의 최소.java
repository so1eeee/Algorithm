import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long totalSum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = N - 1; i >= 0; i--) {
			min = Math.min(min, A[i]);
			totalSum += min;
		}
		System.out.println(totalSum);
	}
}
