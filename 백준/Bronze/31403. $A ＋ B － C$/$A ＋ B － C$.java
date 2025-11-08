import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		System.out.println(A + B - C);
		String a = String.valueOf(A);
		String b = String.valueOf(B);
		String abStr = a + b;
		int abInt = Integer.valueOf(abStr);
		System.out.println(abInt - C);
	}
}
