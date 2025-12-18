import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Deque<Character> deque = new ArrayDeque<>();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '('){
				deque.offer(str.charAt(i));
			} else {
				deque.pollLast();
				if (str.charAt(i - 1) == '(') {
					cnt += deque.size();
				} else {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
