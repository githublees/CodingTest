import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X+1];
        int[] process = new int[X+1];
        for (int i = 0; i <= X; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;
        for (int i = 2; i <= X; i++) {

            if (i%3 == 0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1;
                process[i] = i/3;
            }

            if (i%2 == 0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1;
                process[i] = i/2;
            }

            if (i-1 > 0 && dp[i] > dp[i-1]+1) {
                dp[i] = dp[i-1]+1;
                process[i] = i-1;
            }
        }

        System.out.println(dp[X]);
        int num = X;
        for (int i = 0; i <= dp[X]; i++) {
            System.out.print(num + " ");
            num = process[num];
        }
    }
}