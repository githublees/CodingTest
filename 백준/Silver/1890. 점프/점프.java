import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp());
    }

    private static long dp() {
        long[][] dp = new long[N+1][N+1];
        dp[1][1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int next = map[i][j];

                if (next == 0) {
                    break;
                }

                if (i + next <= N) {
                    dp[i+next][j] += dp[i][j];
                }
                if (j + next <= N) {
                    dp[i][j+next] += dp[i][j];
                }
            }
        }

        return dp[N][N];
    }
}