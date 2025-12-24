import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			if(!map.containsKey(c)){
				max = Math.max(max, map.size() + 1);
			} else {
				max = Math.max(max, map.size());
			}
			map.put(arr[i], map.get(arr[i]) - 1);
			if (map.get(arr[i]) == 0) {
				map.remove(arr[i]);
			}
			map.put(arr[(i + k) % N], map.getOrDefault(arr[(i + k) % N], 0) + 1);
		}
		System.out.println(max);
	}
}
