import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        long[][] dp = new long[65][10];
        
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;    
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        
        T = Integer.parseInt(br.readLine());
        
        for (int testcase = 0; testcase < T; testcase++) {

            int N = Integer.parseInt(br.readLine());

            long answer = 0;

            for (int i = 0; i <= 9; i++) {
                answer += dp[N][i];
            }
            
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}