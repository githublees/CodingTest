import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> card = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N --> 0) {
            int num = Integer.parseInt(st.nextToken());

            card.put(num, card.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (M --> 0) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(card.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }
}