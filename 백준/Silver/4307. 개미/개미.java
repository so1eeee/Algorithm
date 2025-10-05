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
		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int fastTime = 0;
			int slowTime = 0;
			for (int j = 0; j < n; j++) {
				int pos = Integer.parseInt(br.readLine());
				int fallShort = Math.min(pos, l - pos);
				int fallLong = Math.max(pos, l - pos);
				fastTime = Math.max(fastTime, fallShort);
				slowTime = Math.max(slowTime, fallLong);
			}
			bw.write(fastTime + " " + slowTime + "\n");
		}
		bw.flush();
	}
}
