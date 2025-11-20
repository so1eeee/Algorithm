import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] A;

	static boolean binarySearch(int target) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(A[mid] == target) {
				return true;
			} else if (A[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int M =  Integer.parseInt(br.readLine());
		st =  new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (binarySearch(target)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}
}
