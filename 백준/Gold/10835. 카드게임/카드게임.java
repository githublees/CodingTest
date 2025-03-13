import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A, B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursive(0, 0));
    }

    private static int recursive(int left, int right) {

        // 한쪽 카드가 전부 소비됐을 때 가능한 값은 0
        if (left == N || right == N) {
            return 0;
        }

        // 이미 값이 있으면 다시 연산할 필요 없음
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        // 카드 두개 다 버리거나, 왼쪽 카드를 버리는 경우 중 큰 수
        dp[left][right] = Math.max(
                recursive(left+1, right+1), recursive(left+1, right)
        );

        // 만약 오른쪽 카드가 더 작다면,
        if (A[left] > B[right]) {
            dp[left][right] = Math.max(
                    dp[left][right], recursive(left, right+1) + B[right]
            );
        }

        return dp[left][right];

    }
}