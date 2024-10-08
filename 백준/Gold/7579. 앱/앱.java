import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] memory, cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 앱의 개수
        N = Integer.parseInt(st.nextToken());
        // 최대 메모리
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[N][10001];

        for (int j = 0; j <= 10000; j++) {
            if (j >= cost[0])
                dp[0][j] = memory[0];
        }

        for (int i = 1; i < N; i++) {

            for (int j = 0; j < 10001; j++) {

                if (j < cost[i]) {

                    dp[i][j] = dp[i-1][j];

                }
                else {

                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + memory[i]);

                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10001; j++) {
                if (dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);

    }
}