import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Room> rooms = new ArrayList<>();
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();
			Player player = new Player(level, nickname);
			boolean joined = false;
			for (Room room : rooms) {
				if (room.canJoin(player.level)) {
					room.addPlayer(player);
					joined = true;
					break;
				}
			}
			if (!joined) {
				rooms.add(new Room(player, m));
			}
		}
		for (Room room : rooms) {
			if(room.started) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			Collections.sort(room.players, (p1, p2) -> p1.nickname.compareTo(p2.nickname));

			for (Player player : room.players) {
				System.out.println(player.level + " " + player.nickname);
			}
		}
	}

	static class Player {
		int level;
		String nickname;

		public Player(int level, String nickname) {
			this.level = level;
			this.nickname = nickname;
		}
	}

	static class Room {
		int roomLevel;
		int capacity;
		boolean started;
		ArrayList<Player> players;

		public Room(Player firstPlayer, int capacity) {
			this.roomLevel = firstPlayer.level;
			this.capacity = capacity;
			this.players = new ArrayList<>();
			this.players.add(firstPlayer);
			if (this.players.size() == this.capacity) {
				this.started = true;
			} else {
				this.started = false;
			}
		}

		public boolean canJoin(int level) {
			if (this.players.size() == this.capacity) {
				return false;
			}
			return level >= (this.roomLevel - 10) &&  level <= (this.roomLevel + 10);
		}

		public void addPlayer(Player player) {
			this.players.add(player);
			if (this.players.size() == this.capacity) {
				this.started = true;
			}
		}
	}
}
