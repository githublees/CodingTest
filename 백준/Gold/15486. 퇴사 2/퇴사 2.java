import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] counsel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        counsel = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int next = i + counsel[i][0] - 1;
            int cost = counsel[i][1];

            // 이전 날 누적값에 오늘 상담을 더한 값을 해당 날에 대입
            if (next <= N) {
                dp[next] = Math.max(dp[next], dp[i - 1] + cost);
            }
            
            // 이전 날과 오늘 중 더 큰 금액 저장
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}