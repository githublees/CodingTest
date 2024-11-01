import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, W;
    static int[] plum;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        plum = new int[T+1];
        for (int i = 1; i <= T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }

        // [현재위치][시간][이동횟수]
        int[][][] dp = new int[3][T+1][W+2];

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W+1; j++) {
                if (plum[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]) + 1;
                    dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]);
                }
                else {
                    if (i == 1 && j == 1) continue;
                    dp[1][i][j] = Math.max(dp[1][i-1][j], dp[2][i-1][j-1]);
                    dp[2][i][j] = Math.max(dp[2][i-1][j], dp[1][i-1][j-1]) + 1;
                }
            }
        }

        for (int i = 1; i <= W+1; i++) {
            answer = Math.max(answer, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(answer);
    }
}