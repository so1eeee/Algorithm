import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] str = br.readLine().split(" ");
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < str.length; i++) {
				String st = str[i];
				String sb = new StringBuilder(st).reverse().toString();
				result.append(sb + " ");
			}
			System.out.println(result);
		}
	}
}
