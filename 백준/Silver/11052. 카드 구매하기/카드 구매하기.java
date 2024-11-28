import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int count = 1; count <= N; count++) {
            cards[count] = Integer.parseInt(st.nextToken());
        }

        int[] dp = cards.clone();

        for (int count = 2; count <= N; count++) {
            for (int remain = 1; remain <= count/2; remain++) {
                dp[count] = Math.max(dp[count], dp[count-remain] + dp[remain]);
            }
        }

        System.out.println(dp[N]);
    }
}