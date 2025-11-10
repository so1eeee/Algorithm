import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String firstWord = br.readLine();
		int[] firstArr = getFrequency(firstWord);
		int similarCnt = 0;
		for (int i = 0; i < N - 1; i++) {
			String otherWord = br.readLine();
			int[] otherArr = getFrequency(otherWord);
			int firstCnt = 0;
			int otherCnt = 0;
			for (int j = 0; j < 26; j++) {
				int diff = firstArr[j] - otherArr[j];
				if (diff > 0) {
					firstCnt += diff;
				} else if (diff < 0) {
					otherCnt -= diff;
				}
			}
			if (isSimilar(firstCnt, otherCnt)) {
				similarCnt++;
			}
		}
		System.out.println(similarCnt);
	}

	static int[] getFrequency(String word) {
		int[] arr = new int[26];
		for (char c : word.toCharArray()) {
			arr[c - 'A']++;
		}
		return arr;
	}

	static boolean isSimilar(int extraInFirst, int extraInOther) {
		if (extraInFirst == 0 && extraInOther == 0) return true;
		if (extraInFirst == 0 && extraInOther == 1) return true;
		if (extraInFirst == 1 && extraInOther == 0) return true;
		if (extraInFirst == 1 && extraInOther == 1) return true;
		return false;
	}
}
