import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long remainder = N % 7;
		if (remainder == 0 || remainder == 2) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
