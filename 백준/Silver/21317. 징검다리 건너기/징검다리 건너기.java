import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, k, min = Integer.MAX_VALUE;
    static int[][] bridge, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        bridge = new int[N+1][2];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bridge[i][0] = Integer.parseInt(st.nextToken());
            bridge[i][1] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());

        dp = new int[N+1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 100000000);
        }
        dp[1][0] = 0;
        if (N >= 2) dp[2][0] = bridge[1][0];
        if (N >= 3) dp[3][0] = Math.min(dp[2][0] + bridge[2][0], bridge[1][1]);

        for (int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + bridge[i - 1][0], dp[i - 2][0] + bridge[i - 2][1]);
            dp[i][1] = dp[i - 3][0] + k;
            dp[i][1] = Math.min(dp[i][1], Math.min(dp[i - 1][1] + bridge[i - 1][0], dp[i - 2][1] + bridge[i - 2][1]));
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}