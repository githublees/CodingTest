import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testcase = 1; ; testcase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[N][3];
            int[][] dp = new int[N][3];

            if (N == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = 1000001;
            dp[0][1] = graph[0][1];
            dp[0][2] = graph[0][1] + graph[0][2];

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][j];
                    } else if (j == 1) {
                        dp[i][j] = Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])))
                                + graph[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2])) + graph[i][j];
                    }
                }
            }

            sb.append(testcase).append(". ").append(dp[N-1][1]).append("\n");
        }

        System.out.println(sb);
    }
}