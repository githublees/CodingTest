import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int number = A; number <= B; number++) {

            int primeCount = primeFactorization(number);

            if (isPrime(primeCount)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int primeCount) {

        if (primeCount < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(primeCount); i++) {
            if (primeCount % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int primeFactorization(int number) {

        int underPrime = 0;

        for (int divide = 2; divide <= Math.sqrt(number); divide++) {
            while (number % divide == 0) {
                number /= divide;
                underPrime++;
            }
        }

        if (number != 1) {
            underPrime++;
        }

        return underPrime;
    }
}