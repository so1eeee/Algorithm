import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			Deque<Integer> deque = new ArrayDeque<>();
			String str = br.readLine();
			boolean flag = false;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					deque.offer(i);
				} else {
					if (deque.isEmpty()) {
						flag = true;
					}
					deque.pollLast();
				}
			}
			if (!deque.isEmpty() || flag) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
