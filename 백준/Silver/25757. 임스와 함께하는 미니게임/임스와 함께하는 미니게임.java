import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String type = st.nextToken();
		int num = -1;
		switch (type) {
			case "Y":
				num = 2;
				break;
			case "F":
				num = 3;
				break;
			case "O":
				num = 4;
				break;
		}
		HashSet<String> names = new HashSet<>();
		for (int i = 0; i < N; i++) {
			names.add(br.readLine());
		}
		System.out.println(names.size() / (num - 1));
	}
}
