import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

class Planet {
	int id, x, y, z;

	public Planet(int id, int x, int y, int z) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planets[i] = new Planet(i, x, y, z);
		}
		ArrayList<Edge> list = new ArrayList<>();
		Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planets[i].x - planets[i + 1].x);
			list.add(new Edge(planets[i].id, planets[i + 1].id, weight));
		}
		Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planets[i].y - planets[i + 1].y);
			list.add(new Edge(planets[i].id, planets[i + 1].id, weight));
		}
		Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < N - 1; i++) {
			int weight = Math.abs(planets[i].z - planets[i + 1].z);
			list.add(new Edge(planets[i].id, planets[i + 1].id, weight));
		}
		Collections.sort(list, (e1, e2) -> e1.weight - e2.weight);
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		int result = 0;
		for (Edge edge : list) {
			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				result += edge.weight;
			}
		}
		System.out.println(result);
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
}
