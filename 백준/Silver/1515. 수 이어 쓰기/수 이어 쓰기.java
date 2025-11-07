import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = 1;
		int idx = 0;
		while (true) {
			String numStr = String.valueOf(N);
			for (int i = 0; i < numStr.length(); i++) {
				char c = numStr.charAt(i);
				if (idx < str.length() && c == str.charAt(idx)) {
					idx++;
				}
			}
			if (idx == str.length()) {
				System.out.println(N);
				break;
			}
			N++;
		}
	}
}
