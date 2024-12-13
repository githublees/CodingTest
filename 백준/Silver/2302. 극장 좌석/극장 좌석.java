import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] fixed = new int[M];
        for (int i = 0; i < M; i++) {
            fixed[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i- 2];
        }

        int answer = 1;

        int index = 0;
        for (int i = 0; i < M; i++) {
            answer *= dp[fixed[i] - index - 1];
            index = fixed[i];
        }
        answer *= dp[N - index];

        System.out.println(answer);
    }
}