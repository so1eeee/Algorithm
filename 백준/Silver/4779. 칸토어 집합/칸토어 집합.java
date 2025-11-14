import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] line;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int N = Integer.parseInt(input.trim());
			int length = (int) Math.pow(3, N);
			line = new char[length];
			Arrays.fill(line, ' ');
			solve(0, length);
			sb.append(line).append("\n");
		}
		System.out.print(sb);
	}

	static void solve(int start, int length) {
		if (length == 1) {
			line[start] = '-';
			return;
		}
		solve(start, length / 3);
		solve(start + ((length / 3) * 2), length / 3);
	}
}
