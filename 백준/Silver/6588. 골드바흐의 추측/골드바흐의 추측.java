import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int MAX = 1000000;
    static boolean[] prime = new boolean[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        findPrimeNumber();

        while (n != 0) {

            boolean flag = false;

            for (int i = n; i >= 0 ; i--) {

                if (!prime[i] && !prime[n - i]) {
                    System.out.println(n + " = " + (n-i) + " + " + i);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }

            n = Integer.parseInt(br.readLine());
        }
    }

    private static void findPrimeNumber() {

        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(MAX); i++) {

            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}