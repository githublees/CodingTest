import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] card, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        card = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            dp[i] = card[i];
        }

        for (int count = 2; count <= N; count++) {
            for (int remain = 1; remain <= count/2 ; remain++) {
                dp[count] = Math.min(dp[count], dp[count-remain] + dp[remain]);
            }
        }

        System.out.println(dp[N]);
    }
}