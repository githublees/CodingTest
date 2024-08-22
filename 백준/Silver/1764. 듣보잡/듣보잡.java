import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();

        while (N --> 0) {
            String n = br.readLine();
            map.put(n, 1);
        }

        while (M --> 0) {
            String m = br.readLine();
            if (map.containsKey(m)) answer.add(m);
        }
        Collections.sort(answer);

        System.out.println(answer.size());
        answer.stream().forEach(item -> System.out.println(item));
    }
}