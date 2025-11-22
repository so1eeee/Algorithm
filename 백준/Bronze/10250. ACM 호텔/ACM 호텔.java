import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor;
            int roomNumber;
            if (N % H == 0) {
                floor = H;
                roomNumber = N / H;
            } else {
                floor = N % H;
                roomNumber = (N / H) + 1;
            }
            sb.append(floor * 100 + roomNumber).append('\n');
        }
        System.out.print(sb);
    }
}