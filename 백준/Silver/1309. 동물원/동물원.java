import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] cage = new long[N+1][3];

        cage[1][0] = cage[1][1] = cage[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            cage[i][0] = (cage[i-1][0] + cage[i-1][1] + cage[i-1][2]) % MOD;
            cage[i][1] = (cage[i-1][0] + cage[i-1][2]) % MOD;
            cage[i][2] = (cage[i-1][0] + cage[i-1][1]) % MOD;
        }

        long answer = (cage[N][0] + cage[N][1] + cage[N][2]) % MOD;
        System.out.println(answer);
    }
}