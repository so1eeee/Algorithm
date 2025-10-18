import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int cnt = 0;
		int i = 1;
		while(true){
			sum += i;
			cnt++;
			if (sum > S) {
				System.out.println(cnt - 1);
				break;
			} else if (sum == S) {
				System.out.println(cnt);
				break;
			}
			i++;
		}
	}
}
