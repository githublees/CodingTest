import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            
            dp[0] = 1;

            for (int n = 1; n <= N; n++) {
                for (int m = coins[n]; m <= M; m++) {
                    dp[m] += dp[m - coins[n]];
                }
            }

            System.out.println(dp[M]);
        }
    }
}