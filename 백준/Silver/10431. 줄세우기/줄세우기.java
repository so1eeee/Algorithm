import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		for (int p = 0; p < P; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int[] heights = new int[20];
			for (int i = 0; i < 20; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer> line = new ArrayList<>();
			int totalCnt = 0;
			for (int curHeight : heights) {
				int idx = line.size();
				int curCnt = 0;
				for (int j = 0; j < line.size(); j++) {
					if (line.get(j) > curHeight) {
						idx = j;
						curCnt = line.size() - j;
						break;
					}
				}
				totalCnt += curCnt;
				line.add(idx, curHeight);
			}
			System.out.println(T + " " + totalCnt);
		}
	}
}
