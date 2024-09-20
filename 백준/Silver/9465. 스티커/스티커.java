import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            int n = Integer.parseInt(br.readLine());

            int[][] desk = new int[2][n];

            for (int i = 0; i < 2; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {

                    desk[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            int[][] dp = new int[2][n];

             dp[0][0] = desk[0][0];
             dp[1][0] = desk[1][0];
            // dp[0][1] = desk[i][j] + dp[i+1][j-1]
            // dp[1][1] = desk[i][j] + dp[i-1][j-1]
            // dp[0][2] = Math.max( desk[i][j] + dp[i+1][j-2], desk[i][j] + dp[i+1][j-1] )
            // dp[1][2] = Math.max( desk[i][j] + dp[i-1][j-2], desk[i][j] + dp[i-1][j-1] )

            int answer = Math.max(dp[0][0], dp[1][0]);

            for (int j = 1; j < n; j++) {

                for (int i = 0; i < 2; i++) {

                    if (j == 1) {

                        if (i == 0) {
                            dp[i][j] = desk[i][j] + dp[i+1][j-1];
                        } else {
                            dp[i][j] = desk[i][j] + dp[i-1][j-1];
                        }

                    } else {

                        if (i == 0) {
                            dp[i][j] = desk[i][j] + Math.max(dp[i+1][j-2], dp[i+1][j-1]);
                        } else {
                            dp[i][j] = desk[i][j] + Math.max(dp[i-1][j-2], dp[i-1][j-1]);
                        }

                    }

                    answer = Math.max(answer, dp[i][j]);
                }

            }

            System.out.println(answer);
        }
    }
}