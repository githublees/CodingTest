import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int[] order;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());
        order = new int[K+1];

        dp= new int[21][21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 1; i <= K; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(recursive(x, y, 1));
    }

    private static int recursive(int x, int y, int c) {

        if (c == K+1) {
            return 0;
        }

        if (dp[x][y][c] != -1) {
            return dp[x][y][c];
        }

        return Math.min(
                Math.abs(order[c] - x) + recursive(order[c], y, c+1),
                Math.abs(order[c] - y) + recursive(x, order[c], c+1));
    }
}