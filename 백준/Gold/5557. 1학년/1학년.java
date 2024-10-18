import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // dp[a][b] = numbers[a]번째 수로 b를 만들 수 있는 경우의 수
        long[][] dp = new long[N][21];
        dp[0][numbers[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (j-numbers[i] >= 0)  dp[i][j] += dp[i-1][j-numbers[i]];
                if (j+numbers[i] <= 20) dp[i][j] += dp[i-1][j+numbers[i]];
            }
        }

        System.out.println(dp[N-2][numbers[N-1]]);
    }
}