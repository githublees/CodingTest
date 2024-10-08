import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[501][501];

        // 목적지
        for (int i = 2; i <= N; i++) {

            // 출발지
            for (int j = i-1; j > 0; j--) {

                dp[j][i] = Integer.MAX_VALUE;

                for (int k = j; k < i; k++) {

                    dp[j][i] = Math.min(dp[j][i],
                            dp[j][k] + dp[k+1][i] + matrix[j][0] * matrix[k][1] * matrix[i][1]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}