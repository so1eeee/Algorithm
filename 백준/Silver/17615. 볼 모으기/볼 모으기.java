import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int redCount = 0;
		int blueCount = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'R') {
				redCount++;
			} else {
				blueCount++;
			}
		}
		int rightCount = 0;
		char lastColor = str.charAt(N - 1);
		for (int i = N - 1; i >= 0; i--) {
			if (str.charAt(i) == lastColor) {
				rightCount++;
			} else {
				break;
			}
		}
		int min = Integer.MAX_VALUE;
		if (lastColor == 'R') {
			min = Math.min(min, redCount - rightCount);
		} else {
			min = Math.min(min, redCount);
		}
		if (lastColor == 'B') {
			min = Math.min(min, blueCount - rightCount);
		} else {
			min = Math.min(min, blueCount);
		}
		int leftCount = 0;
		char firstColor = str.charAt(0);
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == firstColor) {
				leftCount++;
			} else {
				break;
			}
		}
		if (firstColor == 'R') {
			min = Math.min(min, redCount - leftCount);
		} else {
			min = Math.min(min, redCount);
		}
		if (firstColor == 'B') {
			min = Math.min(min, blueCount - leftCount);
		} else {
			min = Math.min(min, blueCount);
		}
		System.out.println(min);
	}
}
