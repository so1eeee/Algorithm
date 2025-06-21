import java.util.Scanner;

class Main {
    private static int N;
    private static boolean[] col;
    private static boolean[] diagUpRight;
    private static boolean[] diagUpLeft;

    private static int solve(int row) {
        if (row == N) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (col[i] || diagUpRight[i + row] || diagUpLeft[i - row + N]) {
                continue;
            }
            col[i] = diagUpRight[i + row] = diagUpLeft[i - row + N] = true;
            count += solve(row + 1);
            col[i] = diagUpRight[i + row] = diagUpLeft[i - row + N] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        col = new boolean[N];
        diagUpRight = new boolean[2 * N];
        diagUpLeft = new boolean[2 * N];

        int result = solve(0);
        System.out.println(result);
    }
}
