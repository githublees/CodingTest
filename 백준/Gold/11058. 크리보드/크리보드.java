import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        for (int click = 1; click <= N; click++) {

            dp[click] = dp[click-1] + 1;

            if (click > 6) {

                for (int i = 3; i <= 5; i++) {
                    dp[click] = Math.max(dp[click], dp[click-i] * (i-1));
                }
            }
        }

        System.out.println(dp[N]);
    }
}