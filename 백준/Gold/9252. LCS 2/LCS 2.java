import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = 0;

        char[] row = br.readLine().toCharArray();
        char[] col = br.readLine().toCharArray();

        int r = row.length;
        int c = col.length;

        int[][] dp = new int[row.length+1][col.length+1];

        for (int i = 1; i <= row.length; i++) {

            for (int j = 1; j <= col.length; j++) {

                if (row[i-1] == col[j-1]) {

                    dp[i][j] = dp[i-1][j-1] + 1;

                }
                else {

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                }

                answer = Math.max(answer, dp[i][j]);
            }
        }

        Stack<Character> stack = new Stack<>();

        while (r > 0 && c > 0) {

            if (dp[r][c] == dp[r-1][c]) {
                r--;
            }
            else if (dp[r][c] == dp[r][c-1]) {
                c--;
            }
            else {
                stack.push(row[r-1]);
                r--;
                c--;
            }

        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(answer);
        System.out.println(sb);
    }
}