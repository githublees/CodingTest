import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long mod = (long) 1e5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long factorial = 1;
        int two = 0, five = 0;

        for (long i = 2; i <= N; i++) {

            long number = i;

            while (number % 2 == 0) {
                two += 1;
                number /= 2;
            }

            while (number % 5 == 0) {
                five += 1;
                number /= 5;
            }

            factorial = (factorial * number) % mod;
        }

        for (int i = 0; i < two - five; i++) {
            factorial = (factorial * 2) % mod;
        }

        System.out.printf("%05d", factorial);
    }
}