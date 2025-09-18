import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = sc.next().toCharArray();
		}
		int min = 64;
		for (int startI = 0; startI <= N - 8; startI++) {
			for (int startJ = 0; startJ <= M - 8; startJ++) {
				int whiteCnt = 0;
				int blackCnt = 0;
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						char curCol = board[startI + i][startJ + j];
						if ((i + j) % 2 == 0) {
							if (curCol != 'W') 
								whiteCnt++;
							if (curCol != 'B') 
								blackCnt++;
						} else {
							if (curCol != 'W')
								blackCnt++;
							if (curCol != 'B')
								whiteCnt++;
						}
					}
				}
				int curMin = Math.min(whiteCnt, blackCnt);
				min = Math.min(curMin, min);
			}
		}
		System.out.println(min);
	}
}
