import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    static final int MOD = 1_234_567;
    static int[][] dp = new int[1001][10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int N = Integer.parseInt(br.readLine());
            int result = IntStream.of(dp[N]).sum() % MOD;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {

        Arrays.fill(dp[1], 1);

        for (int i = 2; i < 1001; i++) {
            dp[i][0] = dp[i-1][7] % MOD;
            dp[i][1] = (dp[i-1][2] + dp[i-1][4]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][5]) % MOD;
            dp[i][3] = (dp[i-1][2] + dp[i-1][6]) % MOD;
            dp[i][4] = (dp[i-1][1] + dp[i-1][5] + dp[i-1][7]) % MOD;
            dp[i][5] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6] + dp[i-1][8]) % MOD;
            dp[i][6] = (dp[i-1][3] + dp[i-1][5] + dp[i-1][9]) % MOD;
            dp[i][7] = (dp[i-1][4] + dp[i-1][0] + dp[i-1][8]) % MOD;
            dp[i][8] = (dp[i-1][5] + dp[i-1][7] + dp[i-1][9]) % MOD;
            dp[i][9] = (dp[i-1][6] + dp[i-1][8]) % MOD;
        }
    }
}