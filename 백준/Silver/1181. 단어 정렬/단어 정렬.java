import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> wordSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            String word = sc.next();
            wordSet.add(word);
        }

        List<String> wordList = new ArrayList<>(wordSet);

        Collections.sort(wordList, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for(String word : wordList) {
            System.out.println(word);
        }
    }
}
