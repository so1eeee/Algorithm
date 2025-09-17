import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int blockS = sc.nextInt();
		int blockC = sc.nextInt();
		int blockO = sc.nextInt();
		int blockN = sc.nextInt();

		int maxSetsFromSN = (blockS + blockN) / 3;
		int maxSetsFromCO = (blockC + blockO * 2) / 6;
		int result = Math.min(maxSetsFromSN, maxSetsFromCO);
		System.out.println(result);
	}
}
