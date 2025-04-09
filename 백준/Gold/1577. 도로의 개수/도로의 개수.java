import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static boolean[][] horizontal, vertical;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        horizontal = new boolean[N][M+1];
        vertical = new boolean[N+1][M];
        dp = new long[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (b == d) {
                horizontal[Math.min(a, c)][b] = true;
            } else {
                vertical[a][Math.min(b, d)] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (horizontal[i-1][0]) {
                break;
            }
            dp[i][0] = 1L;
        }

        for (int i = 1; i <= M; i++) {
            if (vertical[0][i-1]) {
                break;
            }
            dp[0][i] = 1L;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];

                if (horizontal[i-1][j]) {
                    dp[i][j] -= dp[i-1][j];
                }

                if (vertical[i][j-1]) {
                    dp[i][j] -= dp[i][j-1];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}