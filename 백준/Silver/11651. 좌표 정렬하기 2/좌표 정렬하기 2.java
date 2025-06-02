import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Point> pointList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            pointList.add(new Point(x, y));
        }
        Collections.sort(pointList, (a, b) -> {
            if (a.y != b.y) {
                return a.y - b.y;
            } else {
                return a.x - b.x;
            }
        });

        for(Point point : pointList){
            System.out.println(point.x + " " + point.y);
        }
    }
}

