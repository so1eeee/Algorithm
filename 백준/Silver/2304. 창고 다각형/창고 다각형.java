import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] heights = new int[1001];

		int startL = 1001; // 가장 왼쪽 기둥의 위치
		int endL = 0;      // 가장 오른쪽 기둥의 위치
		int maxH = 0;      // 가장 높은 기둥의 높이
		int maxL = 0;      // 가장 높은 기둥의 위치

		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			heights[L] = H;
			if (L < startL) startL = L;
			if (L > endL) endL = L;
			if (H > maxH) {
				maxH = H;
				maxL = L;
			}
		}

		int totalArea = 0;

		// 왼쪽 부분 면적 계산 (startL 부터 maxL 까지)
		int currentMaxH = 0;
		for (int i = startL; i <= maxL; i++) {
			if (heights[i] > currentMaxH) {
				currentMaxH = heights[i];
			}
			totalArea += currentMaxH;
		}

		// 오른쪽 부분 면적 계산 (endL 부터 maxL + 1 까지)
		currentMaxH = 0;
		for (int i = endL; i > maxL; i--) {
			if (heights[i] > currentMaxH) {
				currentMaxH = heights[i];
			}
			totalArea += currentMaxH;
		}
		System.out.println(totalArea);
	}
}
