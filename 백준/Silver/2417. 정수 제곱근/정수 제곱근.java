import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long low = 0;
		long high = n;
		long result = n;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			BigInteger midBig = BigInteger.valueOf(mid);
			BigInteger nBig = BigInteger.valueOf(n);
			if (midBig.multiply(midBig).compareTo(nBig) >= 0) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(result);
	}
}
