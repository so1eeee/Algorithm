import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = br.readLine();
			if (line.equals("0")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			A = new long[n];
			for (int i = 0; i < n; i++) {
				A[i] = Long.parseLong(st.nextToken());
			}
			sb.append(solve(0, n - 1)).append('\n');
		}
		System.out.print(sb);
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
