import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			int left = arr[i];
			int empty = 0;
			for (int j = 0; j < N; j++) {
				if (res[j] == 0) {
					if(empty == left){
						res[j] = i + 1;
						break;
					}
					empty++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
