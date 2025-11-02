import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}
		while(true) {
			if(deque.size() == 1) {
				break;
			}
			if(!deque.isEmpty()){
				int a = deque.pollFirst();
			}
			if(deque.size() == 1) {
				break;
			}
			int b = -1;
			if(!deque.isEmpty()){
				b = deque.pollFirst();
			}
			deque.addLast(b);
		}
		System.out.println(deque.getFirst());
	}
}
