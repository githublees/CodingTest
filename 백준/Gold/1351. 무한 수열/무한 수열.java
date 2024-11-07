import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static long N, P, Q;
    static Map<Long, Long> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(dfs(N));
    }

    private static long dfs(long i) {

        if (i == 0) {
            return 1;
        }
        
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        dp.put(i, dfs(i / P) + dfs(i / Q));

        return dp.get(i);
    }
}