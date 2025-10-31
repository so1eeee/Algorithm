import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if(N == 0){
			System.out.println(1);
			return;
		}
		ArrayList<Integer> scores = new ArrayList<>();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores.add(Integer.parseInt(st2.nextToken()));
		}
		int rank = 1;
		for (int i = 0; i < N; i++) {
			if (scores.get(i) > score) {
				rank++;
			} else {
				break;
			}
		}
		if (N == P && score <= scores.get(N - 1)) {
			System.out.println(-1);
			return;
		}
		System.out.println(rank);
	}
}
