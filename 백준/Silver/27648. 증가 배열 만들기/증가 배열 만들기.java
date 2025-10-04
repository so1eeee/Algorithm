import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N + M - 1 > K) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					bw.write((i + j - 1) + " ");
				}
				bw.newLine();
			}
			bw.flush();
		}
	}
}
