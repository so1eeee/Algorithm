import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min = Math.max(arr[0], N - arr[M - 1]);
		for (int i = 1; i < M; i++) {
			int gap = arr[i] - arr[i - 1];
			int req = (gap + 1) / 2;
			min = Math.max(min, req);
		}
		System.out.println(min);
	}
}
