import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> card = new ArrayDeque<>();
        for (int i = 1; i <= N ; i++) {
            card.addLast(i);
        }

        while (card.size() > 1) {
            card.pollFirst();
            card.addLast(card.pollFirst());
        }

        System.out.println(card.pollFirst());
    }
}