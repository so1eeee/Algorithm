import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] defCnt = new int[101];
		for (int i = 0; i < N; i++) {
			defCnt[sc.nextInt()]++;
			defCnt[sc.nextInt()]++;
			defCnt[sc.nextInt()]++;
		}
		int winCnt = 0;
		for (int i = 1; i <= 98; i++) {
			for (int j = i + 1; j <= 99; j++) {
				for (int k = j + 1; k <= 100; k++) {
					int[] finalCnt = Arrays.copyOf(defCnt, defCnt.length);
					finalCnt[i]++;
					finalCnt[j]++;
					finalCnt[k]++;
					int bestScore = 0;
					if (finalCnt[i] == 1) bestScore = Math.max(bestScore, i);
					if (finalCnt[j] == 1) bestScore = Math.max(bestScore, j);
					if (finalCnt[k] == 1) bestScore = Math.max(bestScore, k);
					if (bestScore == 0) {
						continue;
					}
					boolean isWin = true;
					for (int otherScore = bestScore + 1; otherScore <= 100; otherScore++) {
						if (finalCnt[otherScore] == 1) {
							isWin = false;
							break;
						}
					}
					if (isWin) {
						winCnt++;
					}
				}
			}
		}
		System.out.println(winCnt);
	}
}
