import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.println("1 0");
                continue;
            }
            
            if (N == 1) {
                System.out.println("0 1");
                continue;
            }

            int[][] dp = fibonacci(N);

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    public static int[][] fibonacci (int n) {
        int[][] dp = new int[n+1][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        return dp;
    }
}