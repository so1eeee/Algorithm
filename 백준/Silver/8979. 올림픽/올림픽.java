import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Country {
	int id;
	int gold;
	int silver;
	int bronze;

	public Country(int id, int gold, int silver, int bronze) {
		this.id = id;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Country> countries = new ArrayList<>();
		int targetGold = -1;
		int targetSilver = -1;
		int targetBronze = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			countries.add(new Country(id, gold, silver, bronze));
			if (id == K) {
				targetGold = gold;
				targetSilver = silver;
				targetBronze = bronze;
			}
		}
		Collections.sort(countries, (c1, c2) -> {
			if (c1.gold != c2.gold) return Integer.compare(c2.gold, c1.gold);
			if (c1.silver != c2.silver) return Integer.compare(c2.silver, c1.silver);
			return Integer.compare(c2.bronze, c1.bronze);
		});
		int rank = -1;
		for (int i = 0; i < N; i++) {
			Country cur = countries.get(i);
			if (cur.gold == targetGold && cur.silver == targetSilver && cur.bronze == targetBronze) {
				rank = i + 1;
				break;
			}
		}
		System.out.println(rank);
	}
}
