import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] words = str.split(" ");
			int idx = -1;
			boolean flag = false;
			int curIdx = 0;
			for (int j = 0; j < words.length; j++) {
				char c = words[j].charAt(0);
				if(!set.contains(Character.toLowerCase(c))) {
					set.add(Character.toLowerCase(c));
					idx = curIdx;
					flag = true;
					break;
				}
				curIdx += words[j].length() + 1;
			}
			if (!flag) {
				for (int j = 0; j < str.length(); j++) {
					char c = str.charAt(j);
					if (c == ' ') {
						continue;
					}
					if(!set.contains(Character.toLowerCase(c))) {
						set.add(Character.toLowerCase(c));
						idx = j;
						flag = true;
						break;
					}
				}
			}
			for (int j = 0; j < str.length(); j++) {
				if (j == idx) {
					System.out.printf("[" + str.charAt(j) + "]");
				} else {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
