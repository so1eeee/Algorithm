import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int zeroCnt = 0;
		int oneCnt = 0;
		for (char c : S.toCharArray()) {
			if (c == '0') {
				zeroCnt++;
			} else {
				oneCnt++;
			}
		}
		int zeroRemoveCnt = zeroCnt / 2;
		int oneRemoveCnt = oneCnt / 2;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char c  = S.charAt(i);
			if (c == '1' && oneRemoveCnt > 0) {
				oneRemoveCnt--;
			} else {
				sb.append(c);
			}
		}
		StringBuilder sb2 =  new StringBuilder();
		String s = sb.toString();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c  = s.charAt(i);
			if (c == '0' && zeroRemoveCnt > 0) {
				zeroRemoveCnt--;
			} else {
				sb2.insert(0, c);
			}
		}
		System.out.println(sb2);
	}
}
