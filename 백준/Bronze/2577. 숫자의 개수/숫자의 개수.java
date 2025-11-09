import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A = Long.parseLong(br.readLine());
		long B = Long.parseLong(br.readLine());
		long C = Long.parseLong(br.readLine());
		long num = A * B * C;
		String numStr = String.valueOf(num);
		int[] arr = new int[10];
		for(char c : numStr.toCharArray()) {
			arr[c - '0'] += 1;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}
