import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] wine, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        wine = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = wine[i];
            }
            else if (i == 2) {
                dp[i] = wine[i] + wine[i-1];
            }
            else {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i] + wine[i-1]));
            }
        }

        System.out.println(dp[N]);
    }
}