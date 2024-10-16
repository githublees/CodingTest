import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int max = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dfs(0,  N);

    }

    private static void dfs(int i, int N) {

        if (N == 0) {
            if (isPrime(i)) {
                System.out.println(i);
            }
            return;
        }

        for (int j = 0; j < 10; j++) {
            int number = i * 10 + j;
            if (isPrime(number)) dfs(number, N-1);
        }
    }

    private static boolean isPrime(int n) {

        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;

    }
}