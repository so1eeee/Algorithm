import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Team {
	int id;
	ArrayList<Integer> scores = new ArrayList<>();
	int top4Sum = 0;
	int score5th = 0;
	int runnerCnt = 0;

	Team(int id) {
		this.id = id;
	}

	void addScore(int score) {
		this.scores.add(score);
	}

	void addRunnerCnt() {
		this.runnerCnt++;
	}

	void calculateFinalScore() {
		for (int i = 0; i < 4; i++) {
			this.top4Sum += this.scores.get(i);
		}
		this.score5th = this.scores.get(4);
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			HashMap<Integer, Team> teams = new HashMap<>();
			for (int teamId : arr) {
				Team team = teams.getOrDefault(teamId, new Team(teamId));
				team.addRunnerCnt();
				teams.put(teamId, team);
			}
			int curScore = 1;
			for (int teamId : arr) {
				Team team = teams.get(teamId);
				if (team.runnerCnt == 6) {
					team.addScore(curScore);
					curScore++;
				}
			}
			List<Team> teamList = new ArrayList<>();
			for (Team team : teams.values()) {
				if (team.runnerCnt == 6) {
					team.calculateFinalScore();
					teamList.add(team);
				}
			}
			Collections.sort(teamList, (t1, t2) -> {
				if(t1.top4Sum != t2.top4Sum) {
					return Integer.compare(t1.top4Sum, t2.top4Sum);
				}
				return Integer.compare(t1.score5th, t2.score5th);
			});
			System.out.println(teamList.get(0).id);
		}
	}
}
