import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		for (int y = 0; y * 5 <= N; y++) {
			for (int x = 0; x * 3 + y * 5 <= N; x++) {
				if (x * 3 + y * 5 == N) {
					min = Math.min(min, x + y);
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}
