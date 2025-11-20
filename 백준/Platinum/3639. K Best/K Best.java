import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static Jewel[] jewels;

	static class Jewel {
		int id;
		int v;
		int w;
		double value;

		public Jewel(int id, int v, int w) {
			this.id = id;
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		jewels = new Jewel[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(i, v, w);
		}
		double low = 0.0;
		double high = 1000000.0;
		for (int i = 0; i < 100; i++) {
			double mid = (low + high) / 2;
			if (check(mid)) {
				low = mid;
			} else {
				high = mid;
			}
		}
		for (Jewel j : jewels) {
			j.value = j.v - (low * j.w);
		}
		Arrays.sort(jewels, (j1, j2) -> Double.compare(j2.value, j1.value));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(jewels[i].id + 1).append(i == k - 1 ? "" : " ");
		}
		System.out.println(sb);
	}

	static boolean check(double x) {
		for (Jewel j : jewels) {
			j.value = j.v - x * j.w;
		}
		Arrays.sort(jewels, (j1, j2) -> Double.compare(j2.value, j1.value));
		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum += jewels[i].value;
		}
		return sum >= 0;
	}
}
