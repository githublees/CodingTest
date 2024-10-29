import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[4][n + 1];

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= 3; j++) {

                    if (i <= j) {
                        dp[j][i] = dp[j][i - 1] + 1;
                        continue;
                    }

                    if (j == 1) {
                        dp[j][i] = dp[j][i - 1];
                    } else if (j == 2) {
                        dp[j][i] = dp[j - 1][i] + dp[j][i - 2];
                    } else if (j == 3) {
                        dp[j][i] = dp[j - 1][i] + dp[j][i - 3];
                    }
                }
            }

            System.out.println(dp[3][n]);
        }
    }
}