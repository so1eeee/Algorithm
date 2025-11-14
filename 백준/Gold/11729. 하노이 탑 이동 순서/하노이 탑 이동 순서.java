import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println((1 << n) - 1);
		f(n, 1, 2, 3);
		System.out.println(sb);
	}

	static void f(int k, int a, int b, int c) {
		if (k == 1) {
			sb.append(a).append(" ").append(c).append("\n");
			return;
		}
		f(k - 1, a, c, b);
		f(1, a, b, c);
		f(k - 1, b, a, c);
	}
}
