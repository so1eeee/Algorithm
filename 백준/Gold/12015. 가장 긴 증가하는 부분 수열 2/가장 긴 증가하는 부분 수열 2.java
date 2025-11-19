import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : A) {
			if (list.isEmpty() || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int idx = binarySearch(list, num);
				list.set(idx, num);
			}
		}
		System.out.println(list.size());
	}

	static int binarySearch(ArrayList<Integer> list, int target) {
		int low = 0;
		int high = list.size() - 1;
		int result = list.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid) >= target) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}
}