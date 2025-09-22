import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] bets = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			bets[i][0] = Integer.parseInt(st.nextToken());
			bets[i][1] = Integer.parseInt(st.nextToken());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int winnableCount = 0;
			for (int i = 0; i < N; i++) {
				int a = bets[i][0];
				int b = bets[i][1];
				if (x <= a && y <= b && a + b <= g) {
					winnableCount++;
				}
			}
			bw.write(winnableCount + "\n");
		}
		bw.flush();
	}
}
