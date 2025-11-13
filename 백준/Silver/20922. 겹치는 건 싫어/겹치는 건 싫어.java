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
		int[] arr = new int[N];
		int[] cnt = new int[100001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int lt = 0;
		for (int rt = 0; rt < N; rt++) {
			int rightNum = arr[rt];
			cnt[rightNum]++;
			while (cnt[rightNum] > K) {
				int leftNum = arr[lt];
				cnt[leftNum]--;
				lt++;
			}
			max = Math.max(max, rt - lt + 1);
		}
		System.out.println(max);
	}
}
