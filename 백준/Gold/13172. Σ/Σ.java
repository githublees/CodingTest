import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = 1L, S = 0;
        int M = Integer.parseInt(br.readLine());

        // 기댓값 합 구하기
        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // 각 분모와 분자를 통분하여 계산
            S = s * N + S* n;
            N *= n;

            // 모듈러 산술로 나머지 계산
            S %= MOD;
            N %= MOD;
        }

        // 기약 분수일 때
        if (S % N != 0) {
            System.out.println(find(N, MOD-2) * S % MOD + " ");
        } else {
            System.out.println(S/N);
        }
    }

    private static long find(long N, int index) {

        if (index == 1) {
            return N;
        }

        long temp = find(N, index/2);

        if (index % 2 == 1) {
            return temp * temp % MOD * N % MOD;
        } else {
            return temp * temp % MOD;
        }
    }
}