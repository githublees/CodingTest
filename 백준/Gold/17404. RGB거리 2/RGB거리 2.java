import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] price = new int[N][3];
        int[][] dp = new int[N+1][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            price[i][0] = R;
            price[i][1] = G;
            price[i][2] = B;
        }

        int answer = INF;

        for (int k = 0; k < 3; k++) {

            for (int i = 0; i < 3; i++) {

                if (k == i)
                    dp[0][i] = price[0][i];
                else
                    dp[0][i] = INF;

            }

            for (int i = 1; i < N; i++) {

                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];

            }

            for (int i = 0; i < 3; i++) {

                if (k != i)
                    answer = Math.min(answer, dp[N-1][i]);
            }
        }

        System.out.println(answer);
    }
}