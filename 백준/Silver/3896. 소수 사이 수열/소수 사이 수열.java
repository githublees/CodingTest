import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX = 1299710;

    static boolean[] prime;
    static int[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prime = new boolean[MAX];
        primes = new int[100000];

        findPrime();

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int k = Integer.parseInt(br.readLine());

//            solution_1(k);
            solution_2(k);
        }
    }

    private static void solution_1(int k) {
        if (prime[k]) {
            int start = k;
            int end = k;

            while (true) {
                if (!prime[--start]) break;
            }

            while (true) {
                if (!prime[++end]) break;
            }
            System.out.println(end - start);

        } else {
            System.out.println(0);
        }
    }

    private static void solution_2(int k) {
        int start = 0;
        int end = 99999;

        int answer = 0;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (primes[mid] < k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (primes[start] < k && primes[start+1] > k) {
            answer = primes[start+1] - primes[start];
        }

        System.out.println(answer);

    }

    private static void findPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(MAX); i++) {

            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < MAX; j+=i) {
                prime[j] = true;
            }
        }

        int index = 0;
        for (int i = 2; i < MAX; i++) {
            if (!prime[i]) {
                primes[index++] = i;
            }
        }
    }
}