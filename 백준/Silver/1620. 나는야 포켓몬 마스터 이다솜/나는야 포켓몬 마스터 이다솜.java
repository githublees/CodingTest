import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> nbook = new HashMap<>();
        Map<String, Integer> sbook = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            nbook.put(i, pokemon);
            sbook.put(pokemon, i);
        }

        while (M --> 0) {
            String answer = br.readLine();
            String result = sbook.containsKey(answer) ? String.valueOf(sbook.get(answer)) : nbook.get(Integer.parseInt(answer));
            System.out.println(result);
        }
    }
}