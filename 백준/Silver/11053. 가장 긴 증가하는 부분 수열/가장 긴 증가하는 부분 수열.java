import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 1;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < i; j++) {

                if (num[i] > num[j]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }

            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}