import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp();

        while (true) {

            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            System.out.println(dp[N][N]);
        }
    }

    private static void dp() {
        for (int w = 0; w < 31; w++) {
            for (int h = 0; h < 31; h++) {

                if (h > w) {
                    continue;
                }

                if (h == 0) {
                    dp[w][h] = 1;
                }
                else {
                    dp[w][h] = dp[w][h-1] + dp[w-1][h];
                }
            }
        }
    }
}