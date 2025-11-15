import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Line {
	int a;
	int b;

	public Line(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lines[i] = new Line(a, b);
		}
		Arrays.sort(lines, (l1, l2) -> l1.a - l2.a);
		int[] bSequence = new int[N];
		for (int i = 0; i < N; i++) {
			bSequence[i] = lines[i].b;
		}
		int[] dp = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (bSequence[j] < bSequence[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
	}
}
