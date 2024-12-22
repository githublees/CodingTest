import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[D+1];

        for (int A = 1; A < K/2; A++) {
            for (int B = A + 1; B < K; B++) {

                dp[1] = A;
                dp[2] = B;

                for (int C = 3; C <= D; C++) {
                    dp[C] = dp[C - 1] + dp[C - 2];
                }

                if (dp[D] == K) {
                    System.out.println(A);
                    System.out.println(B);
                    return;
                }
            }
        }
    }
}