import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long B;
	static long[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		arr = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Long.parseLong(st.nextToken()) % 1000;
			}
		}
		long[][] result = f(arr, B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	static long[][] f(long[][] arr, long b) {
		if (b == 1) {
			return arr;
		}
		long[][] temp = f(arr, b / 2);
		temp = multiply(temp, temp);
		if (b % 2 == 1) {
			temp = multiply(temp, arr);
		}
		return temp;
	}

	static long[][] multiply(long[][] o1, long[][] o2) {
		long[][] temp = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					temp[i][j] += o1[i][k] * o2[k][j];
					temp[i][j] %= 1000;
				}
			}
		}
		return temp;
	}
}
