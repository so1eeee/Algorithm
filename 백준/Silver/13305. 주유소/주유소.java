import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N - 1];
		int[] cost = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st2.nextToken());
		}
		int minCost = cost[0];
		int sumCost = 0;
		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < minCost) {
				minCost = cost[i];
			}
			sumCost += minCost * dist[i];
		}
		System.out.println(sumCost);
	}
}
