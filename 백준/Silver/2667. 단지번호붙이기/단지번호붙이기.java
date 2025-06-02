import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String line = sc.nextLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    int houseCount = dfs(i, j);
                    complexes.add(houseCount);
                }
            }
        }

        Collections.sort(complexes);

        System.out.println(complexes.size());
        for (int count : complexes) {
            System.out.println(count);
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    count += dfs(nx, ny);
                }
            }
        }
        return count;
    }
}
