import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[][] dp = new int[A.length+1][B.length+1];

        int answer = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {

                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        System.out.println(answer);
    }
}