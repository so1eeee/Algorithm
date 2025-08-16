import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		HashSet<String> subStrings = new HashSet<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				subStrings.add(s.substring(i, j));
			}
		}
		System.out.println(subStrings.size());
	}
}