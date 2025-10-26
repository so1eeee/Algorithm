import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		int cnt0 = 0;
		int cnt1 = 0;
		if (s.charAt(0) == '0') {
			cnt0++;
		} else {
			cnt1++;
		}
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				if (s.charAt(i) == '0') {
					cnt0++;
				} else {
					cnt1++;
				}
			}
		}
		System.out.println(Math.min(cnt0, cnt1));
	}
}
