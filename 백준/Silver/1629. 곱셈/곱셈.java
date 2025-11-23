import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		long result = f(A, B);
		System.out.println(result);
	}

	static long f(long a, long b) {
		if (b == 1) {
			return a % C;
		}
		long mid = b / 2;
		long temp = f(a, mid);
		if(b % 2 == 1) {
			return (temp * temp % C) * a % C;
		}
		return temp * temp % C;
	}
}
