import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		solve(0, 0, N);
		for (int i = 0; i < N; i++) {
			bw.write(map[i]);
			bw.newLine();
		}
		bw.flush();
	}

	static void solve(int r, int c, int n) {
		if (n == 1) {
			map[r][c] = '*';
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) {
					solve(r + (i * (n / 3)), c + (j * (n / 3)), n / 3);
				}
			}
		}
	}
}
