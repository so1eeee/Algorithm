import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dist = new long[N - 1];
		long[] cost = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st2.nextToken());
		}
		long minCost = cost[0];
		long totalCost = 0;
		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < minCost) {
				minCost = cost[i];
			}
			totalCost += minCost * dist[i];
		}
		System.out.println(totalCost);
	}
}
