import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int heartX = -1, heartY = -1;
		boolean	flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '*'){
					heartX = i + 1;
					heartY = j;
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		System.out.println((heartX + 1) + " " + (heartY + 1));
		int leftArm = 0, rightArm = 0, waist = 0, waistEndX = -1, leftLeg = 0, rightLeg = 0;
		for (int j = heartY - 1; j >= 0 && map[heartX][j] == '*'; j--) {
			leftArm++;
		}
		for (int j = heartY + 1; j < N && map[heartX][j] == '*'; j++) {
			rightArm++;
		}
		for (int i = heartX + 1; i < N && map[i][heartY] == '*'; i++) {
			waist++;
			waistEndX = i;
		}
		for (int i = waistEndX + 1; i < N && map[i][heartY - 1] == '*'; i++) {
			leftLeg++;
		}
		for (int i = waistEndX + 1; i < N && map[i][heartY + 1] == '*'; i++) {
			rightLeg++;
		}
		System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
	}
}
