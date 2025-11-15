import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dpUp = new int[N];
		int[] dpDown = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			dpUp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
				}
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			dpDown[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (A[j] < A[i]) {
					dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dpUp[i] + dpDown[i] - 1);
		}
		System.out.println(max);
	}
}
