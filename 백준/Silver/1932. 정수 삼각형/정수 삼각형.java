import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] numbers = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {

                int num = Integer.parseInt(st.nextToken());

                numbers[i][j] = num;

            }
        }

        dp[0][0] = numbers[0][0];

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + numbers[i][j];
                }
                else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + numbers[i][j];
                }
                else {
                    dp[i][j] = Math.max(numbers[i][j] + dp[i-1][j-1], numbers[i][j] + dp[i - 1][j]);
                }
            }

        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        System.out.println(answer);
    }
}