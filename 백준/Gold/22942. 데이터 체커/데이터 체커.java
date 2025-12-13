import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Circle {
	int id;
	int left;
	int right;

	public Circle(int id, int x, int r) {
		this.id = id;
		this.left = x - r;
		this.right = x + r;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Circle[] circles = new Circle[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			circles[i] = new Circle(i, x, r);
		}
		Arrays.sort(circles, (c1, c2) -> {
			if (c1.left == c2.left) {
				return c1.right - c2.right;
			}
			return c1.left - c2.left;
		});
		Deque<Circle> deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			Circle cur = circles[i];
			while (!deque.isEmpty() && deque.peekLast().right < cur.left) {
				deque.pollLast();
			}
			if (!deque.isEmpty()) {
				Circle parent = deque.peekLast();
				if (parent.right == cur.left) {
					System.out.println("NO");
					return;
				}
				if (cur.right >= parent.right) {
					System.out.println("NO");
					return;
				}
			}
			deque.offer(cur);
		}
		System.out.println("YES");
	}
}
