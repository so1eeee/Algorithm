import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static class Docs {
        int index;
        int priority;

        Docs(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            int n = sc.nextInt(); // 문서의 개수
            int m = sc.nextInt(); // 궁금한 문서 위치

            Deque<Docs> deque = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                int priority = sc.nextInt();
                deque.offerLast(new Docs(j, priority));
            }

            int printOrder = 0;

            while (!deque.isEmpty()) {
                Docs cur = deque.pollFirst();

                boolean hasHigher = false;
                for (Docs doc : deque) {
                    if (doc.priority > cur.priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    deque.offerLast(cur);
                } else {
                    printOrder++;
                    if (cur.index == m) {
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
            
        }
    }
}
