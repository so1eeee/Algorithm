import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int height = (H + N) / (N + 1);
        int width = (W + M) / (M + 1);
        System.out.println(height * width);
    }
}
