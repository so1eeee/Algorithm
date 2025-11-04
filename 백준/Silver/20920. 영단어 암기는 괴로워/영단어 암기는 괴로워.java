import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() >= M) {
				hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
			}
		}
		ArrayList<String> words = new ArrayList<>(hashMap.keySet());
		Collections.sort(words, (w1, w2) -> {
			int cnt1 = hashMap.get(w1);
			int cnt2 = hashMap.get(w2);
			if (cnt1 != cnt2) {
				return Integer.compare(cnt2, cnt1);
			}
			if (w1.length() != w2.length()) {
				return Integer.compare(w2.length(), w1.length());
			}
			return w1.compareTo(w2);
		});
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(String word : words) {
			bw.write(word);
			bw.newLine();
		}
		bw.flush();
	}
}
