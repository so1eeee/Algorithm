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
		int M = Integer.parseInt(br.readLine());
		int set = 0;
		int all = (1 << 21) - 2;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}
			switch (cmd) {
				case "add":
					set |= (1 << x);
					break;
				case "remove":
					set &= ~(1 << x);
					break;
				case "check":
					if ((set & (1 << x)) != 0) {
						bw.write("1\n");
					} else {
						bw.write("0\n");
					}
					break;
				case "toggle":
					set ^= (1 << x);
					break;
				case "all":
					set = all;
					break;
				case "empty":
					set = 0;
					break;
			}
		}
		bw.flush();
	}
}
