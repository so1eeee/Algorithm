import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		A = new long[N];
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(br.readLine());
		}
		System.out.println(solve(0, N - 1));
	}

	static long solve(int l, int r) {
		if (l == r) {
			return A[l];
		}
		int m = (l + r) / 2;
		long result = Math.max(solve(l, m), solve(m + 1, r));
		long max = 0;
		long minHeight = Long.MAX_VALUE;
		int i = m;
		int j = m + 1;
		int w = 0;
		while (i >= l && j <= r) {
			if (A[i] > A[j]) {
				minHeight = Math.min(minHeight, A[i]);
				i--;
			} else {
				minHeight = Math.min(minHeight, A[j]);
				j++;
			}
			w++;
			max = Math.max(max, minHeight * w);
		}
		while (i >= l) {
			minHeight = Math.min(minHeight, A[i]);
			i--;
			w++;
			max = Math.max(max, minHeight * w);
		}
		while (j <= r) {
			minHeight = Math.min(minHeight, A[j]);
			j++;
			w++;
			max = Math.max(max, minHeight * w);
		}
		return Math.max(result, max);
	}
}
