import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> channels = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			channels.add(sc.next());
		}

		int kbs1Index = channels.indexOf("KBS1");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < kbs1Index; i++) {
			result.append("1");
		}

		for (int i = kbs1Index; i > 0; i--) {
			result.append("4");
			Collections.swap(channels, i, i - 1);
		}

		if (!channels.get(1).equals("KBS2")) {
			int kbs2Index = channels.indexOf("KBS2");
			for (int i = 0; i < kbs2Index; i++) {
				result.append("1");
			}
			for (int i = kbs2Index; i > 1; i--) {
				result.append("4");
				Collections.swap(channels, i, i - 1);
			}
		}

		System.out.println(result);
	}
}
