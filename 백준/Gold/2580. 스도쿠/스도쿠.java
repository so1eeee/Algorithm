import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] grid = new int[9][9];
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][] box = new boolean[9][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] != 0) {
					int num = grid[i][j];
					row[i][num] = true;
					col[j][num] = true;
					box[(i / 3) * 3 + (j / 3)][num] = true;
				}
			}
		}
		solve(0, 0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean solve(int r, int c) {
		if (c == 9) {
			r++;
			c = 0;
		}
		if (r == 9) {
			return true;
		}
		if (grid[r][c] != 0) {
			return solve(r, c + 1);
		}
		int boxIdx = (r / 3) * 3 + (c / 3);
		for (int num = 1; num <= 9; num++) {
			if (!row[r][num] && !col[c][num] && !box[boxIdx][num]) {
				grid[r][c] = num;
				row[r][num] = true;
				col[c][num] = true;
				box[boxIdx][num] = true;
				if (solve(r, c + 1)) {
					return true;
				}
				grid[r][c] = 0;
				row[r][num] = false;
				col[c][num] = false;
				box[boxIdx][num] = false;
			}
		}
		return false;
	}
}
