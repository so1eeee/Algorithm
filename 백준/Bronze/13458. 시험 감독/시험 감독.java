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
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long totalSupervisors = 0;
		for (int i = 0; i < N; i++) {
			int examinees = A[i];
			totalSupervisors++;
			examinees -= B;
			if (examinees > 0) {
				totalSupervisors += (examinees + C - 1) / C;
			}
		}
		System.out.println(totalSupervisors);
	}
}