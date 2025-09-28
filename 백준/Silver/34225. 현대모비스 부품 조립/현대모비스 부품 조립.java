import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Module {
		int e;
		int idx;

		public Module(int e, int idx) {
			this.e = e;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Module[] modules = new Module[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			modules[i] = new Module(Integer.parseInt(st.nextToken()), i + 1);
		}
		Arrays.sort(modules, (m1, m2) -> m1.e - m2.e);
		long[] prefixSum = new long[N];
		prefixSum[0] = modules[0].e;
		for (int i = 1; i < N; i++) {
			prefixSum[i] = prefixSum[i - 1] + modules[i].e;
		}
		long maxScore = -1;
		int bestI = -1, bestJ = -1;
		long maxStart = -1;
		int bestStartI = -1;

		for (int j = 0; j < N; j++) {
			long curStart = 2L * modules[j].e - prefixSum[j];
			if (curStart > maxStart) {
				maxStart = curStart;
				bestStartI = j;
			}
			long curEnd = (long)modules[j].e + prefixSum[j];
			long totalScore = curEnd + maxStart;
			if (totalScore > maxScore) {
				maxScore = totalScore;
				bestI = bestStartI;
				bestJ = j;
			}
		}
		bw.write(String.valueOf(bestJ - bestI + 1));
		bw.newLine();
		for (int i = bestI; i <= bestJ; i++) {
			bw.write(String.valueOf(modules[i].idx) + " ");
		}
		bw.flush();
	}
}
