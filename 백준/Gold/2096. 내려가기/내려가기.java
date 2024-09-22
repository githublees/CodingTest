import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        number = new int[N][3];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {

                number[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int[][][] dp = new int[2][N][3];

        dp[0][0][0] = dp[1][0][0] = number[0][0];
        dp[0][0][1] = dp[1][0][1] = number[0][1];
        dp[0][0][2] = dp[1][0][2] = number[0][2];

        for (int i = 1; i < N; i++) {

            dp[0][i][0] = Math.max(dp[0][i-1][0], dp[0][i-1][1]) + number[i][0];
            dp[0][i][1] = Math.max(dp[0][i-1][0], Math.max(dp[0][i-1][1], dp[0][i-1][2])) + number[i][1];
            dp[0][i][2] = Math.max(dp[0][i-1][1], dp[0][i-1][2]) + number[i][2];

            dp[1][i][0] = Math.min(dp[1][i-1][0], dp[1][i-1][1]) + number[i][0];
            dp[1][i][1] = Math.min(dp[1][i-1][0], Math.min(dp[1][i-1][1], dp[1][i-1][2])) + number[i][1];
            dp[1][i][2] = Math.min(dp[1][i-1][1], dp[1][i-1][2]) + number[i][2];
        }

        int max = Math.max(dp[0][N-1][0], Math.max(dp[0][N-1][1], dp[0][N-1][2]));
        int min = Math.min(dp[1][N-1][0], Math.min(dp[1][N-1][1], dp[1][N-1][2]));

        System.out.println(max + " " + min);

    }
}