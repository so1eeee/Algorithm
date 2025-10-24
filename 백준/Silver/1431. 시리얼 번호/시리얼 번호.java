import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int calculateSum(String s) {
		int sum = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				sum += c - '0';
			}
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] serials = new String[N];
		for (int i = 0; i < N; i++) {
			serials[i] = br.readLine();
		}
		Arrays.sort(serials, (s1, s2) -> {
			if (s1.length() != s2.length()) {
				return s1.length() - s2.length();
			}
			int sum1 = calculateSum(s1);
			int sum2 = calculateSum(s2);
			if (sum1 != sum2) {
				return sum1 - sum2;
			}
			return s1.compareTo(s2);
		});
		for (String serial : serials) {
			System.out.println(serial);
		}
	}
}
