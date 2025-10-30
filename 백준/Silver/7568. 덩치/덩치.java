import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {
	int x;
	int y;
	int rank;

	public Person(int x, int y) {
		this.x = x;
		this.y = y;
		this.rank = 1;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> persons = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			persons.add(new Person(x, y));
		}
		for (int i = 0; i < N; i++) {
			Person cur = persons.get(i);
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				Person other = persons.get(j);
				if (other.x > cur.x && other.y > cur.y) {
					cnt++;
				}
			}
			cur.rank = cnt + 1;
		}
		for (int i = 0; i < N; i++) {
			System.out.print(persons.get(i).rank + " ");
		}
	}
}
