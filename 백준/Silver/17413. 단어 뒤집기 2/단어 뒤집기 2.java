import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Deque<Character> deque = new ArrayDeque<>();
		boolean flag = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '<') {
				while (!deque.isEmpty()) {
					sb.append(deque.pollLast());
				}
				flag = true;
				sb.append(str[i]);
			} else if (str[i] == '>') {
				flag = false;
				sb.append(str[i]);
			} else if (flag) {
				sb.append(str[i]);
			} else {
				if (str[i] == ' ') {
					while (!deque.isEmpty()) {
						sb.append(deque.pollLast());
					}
					sb.append(str[i]);
				} else {
					deque.offer(str[i]);
				}
			}
		}
		while (!deque.isEmpty()) {
			sb.append(deque.pollLast());
		}
		System.out.println(sb);
	}
}
