import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}