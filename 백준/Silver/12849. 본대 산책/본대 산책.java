import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int D = Integer.parseInt(br.readLine());

        long[][] dp = new long[D+1][8];
        dp[0][0] = 1;

        for (int time = 0; time < D; time++) {
            dp[time + 1][0] = (dp[time][1] + dp[time][2]) % MOD;
            dp[time + 1][1] = (dp[time][0] + dp[time][2] + dp[time][3]) % MOD;
            dp[time + 1][2] = (dp[time][0] + dp[time][1] + dp[time][3] + dp[time][5]) % MOD;
            dp[time + 1][3] = (dp[time][1] + dp[time][2] + dp[time][4] + dp[time][5]) % MOD;
            dp[time + 1][4] = (dp[time][3] + dp[time][5] + dp[time][6]) % MOD;
            dp[time + 1][5] = (dp[time][2] + dp[time][3] + dp[time][4] + dp[time][7]) % MOD;
            dp[time + 1][6] = (dp[time][4] + dp[time][7]) % MOD;
            dp[time + 1][7] = (dp[time][5] + dp[time][6]) % MOD;
        }

        System.out.println(dp[D][0]);
    }
}