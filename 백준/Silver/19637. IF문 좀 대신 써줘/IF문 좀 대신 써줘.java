import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Champion[] champions = new Champion[N];
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			champions[i] = new Champion(name, value);
		}
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			int low = 0;
			int high = N - 1;
			int idx = 0;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (num <= champions[mid].value) {
					idx = mid;
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			bw.write(champions[idx].name);
			bw.write("\n");
		}
		bw.flush();
	}

	static class Champion {
		String name;
		int value;

		public Champion(String name, int value) {
			this.name = name;
			this.value = value;
		}
	}
}
