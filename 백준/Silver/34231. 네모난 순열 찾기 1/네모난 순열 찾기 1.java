import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int permutationCnt = 0;
		for (int r1 = 0; r1 < N; r1++) {
			for (int c1 = 0; c1 < N; c1++) {
				for (int r2 = r1; r2 < N; r2++) {
					for (int c2 = c1; c2 < N; c2++) {
						List<Integer> numbers = new ArrayList<>();
						for (int i = r1; i <= r2; i++) {
							for (int j = c1; j <= c2; j++) {
								numbers.add(board[i][j]);
							}
						}
						if (isPermutation(numbers)) {
							permutationCnt++;
						}
					}
				}
			}
		}
		System.out.println(permutationCnt);
	}

	public static boolean isPermutation(List<Integer> numbers) {
		int size = numbers.size();
		HashSet<Integer> set = new HashSet<>(numbers);
		if (set.size() != size) {
			return false;
		}
		for (int i = 1; i <= size; i++) {
			if (!set.contains(i)) {
				return false;
			}
		}
		return true;
	}
}
