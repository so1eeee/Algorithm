import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int recursive = 0;

	static int fibo(int n){
		if(n == 1 || n == 2){
			recursive++;
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fibo(n);
		int dp = n - 2;
		System.out.println(recursive + " " + dp);
	}
}
