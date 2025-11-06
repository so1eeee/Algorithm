import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] arr = br.readLine().toCharArray();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == 'P'){
				for (int j = i - K; j <= i + K; j++) {
					if (j >= 0 && j < N && arr[j] == 'H') {
						arr[j] = 'E';
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
