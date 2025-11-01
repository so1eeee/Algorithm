import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N;

	static void man(int num){
		for (int i = 1; i <= N; i++) {
			if(i % num == 0){
				arr[i] = 1 - arr[i];
			}
		}
	}

	static void woman(int num){
		int i = num - 1;
		int j = num + 1;
		arr[num] = 1 - arr[num];
		while(i > 0 && i <= N && j > 0 && j <= N){
			if(arr[i] != arr[j]){
				break;
			}
			arr[i] = 1 - arr[i];
			arr[j] = 1- arr[j];
			i--;
			j++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st2.nextToken());
			int num = Integer.parseInt(st2.nextToken());
			if (gender == 1) {
				man(num);
			} else if (gender == 2) {
				woman(num);
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
			if(i % 20 == 0 && i < N){
				System.out.println();
			}
		}
	}
}
