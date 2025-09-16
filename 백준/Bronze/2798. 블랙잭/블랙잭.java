import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] cards;
	static int result = 0;

	public static void dfs(int count, int startIndex, int currentSum) {
		if (currentSum > M) {
			return;
		}
		if (count == 3) {
			if (currentSum > result) {
				result = currentSum;
			}
			return;
		}
		for (int i = startIndex; i < N; i++) {
			dfs(count + 1, i + 1, currentSum + cards[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		dfs(0, 0, 0);
		System.out.println(result);
	}
}