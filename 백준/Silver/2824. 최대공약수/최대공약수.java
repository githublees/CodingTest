import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static BigInteger A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = BigInteger.ONE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A = A.multiply(new BigInteger(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        B = BigInteger.ONE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }

        String answer = A.gcd(B).toString();
        System.out.println(answer.length() > 9 ? answer.substring(answer.length() - 9) : answer);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(a, b%a);
    }
}