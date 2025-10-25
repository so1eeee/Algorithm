import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Team {
	int id;
	int[] scores;
	int submitCnt;
	int lastSubmitTime;
	int totalScore;

	public Team(int id, int k) {
		this.id = id;
		this.scores = new int[k + 1];
		this.submitCnt = 0;
		this.lastSubmitTime = -1;
		this.totalScore = 0;
	}

	public void calculateTotalScore() {
		this.totalScore = 0;
		for (int score : scores) {
			this.totalScore += score;
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int a = 0; a < T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Map<Integer, Team> teams = new HashMap<>();
			for (int b = 0; b < m; b++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				Team curTeam = teams.get(i);
				if (curTeam == null) {
					curTeam = new Team(i, k);
					teams.put(i, curTeam);
				}
				curTeam.scores[j] = Math.max(curTeam.scores[j], s);
				curTeam.submitCnt++;
				curTeam.lastSubmitTime = b;
			}
			for (Team team : teams.values()) {
				team.calculateTotalScore();
			}
			List<Team> rankedTeams = new ArrayList<>(teams.values());
			Collections.sort(rankedTeams, (t1, t2) -> {
				if (t1.totalScore != t2.totalScore) {
					return Integer.compare(t2.totalScore, t1.totalScore);
				}
				if (t1.submitCnt != t2.submitCnt) {
					return Integer.compare(t1.submitCnt, t2.submitCnt);
				}
				return Integer.compare(t1.lastSubmitTime, t2.lastSubmitTime);
			});
			int myRank = 0;
			for (int i = 0; i < rankedTeams.size(); i++) {
				if (rankedTeams.get(i).id == t) {
					myRank = i + 1;
					break;
				}
			}
			System.out.println(myRank);
		}
	}
}
