import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		ArrayDeque<Character> left = new ArrayDeque<>();
		ArrayDeque<Character> right = new ArrayDeque<>();
		for (char ch : str.toCharArray()) {
			left.offer(ch);
		}
		for (int i = 0; i < M; i++) {
			String cmdLine = br.readLine();
			char cmd = cmdLine.charAt(0);
			switch (cmd) {
				case 'L':
					if (!left.isEmpty()) {
						right.offerFirst(left.pollLast());
					}
					break;
				case 'D':
					if (!right.isEmpty()) {
						left.offer(right.poll());
					}
					break;
				case 'B':
					if (!left.isEmpty()) {
						left.pollLast();
					}
					break;
				case 'P':
					char ch = cmdLine.charAt(2);
					left.offer(ch);
					break;
			}
		}
		for (char ch : left) {
			bw.write(ch);
		}
		for (char ch : right) {
			bw.write(ch);
		}
		bw.flush();
	}
}
