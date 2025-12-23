import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int aCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a'){
				aCount++;
			}
		}
		int bCount = 0;
		for (int i = 0; i < aCount; i++) {
			if (s.charAt(i) == 'b') {
				bCount++;
			}
		}
		int min = bCount;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == 'b') {
				bCount--;
			}
			int endIdx = (i + aCount - 1) % s.length();
			if (s.charAt(endIdx) == 'b') {
				bCount++;
			}
			min = Math.min(min, bCount);
		}
		System.out.println(min);
	}
}
