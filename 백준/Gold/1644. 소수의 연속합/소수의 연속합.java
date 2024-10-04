import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        prime = new boolean[5000000];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(5000000); i++) {

            if (prime[i]) continue;

            for (int j = i*i; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }

        int answer = 0, sum = 2;
        int start = 2, end = 2;

        while (start <= end) {

            if (sum == N) {
                answer += 1;
            }

            if (sum < N) {
                while (prime[++end]) {
                }
                sum += end;
            } else {
                sum -= start;
                while (prime[++start]) {
                }
            }
        }

        System.out.println(answer);
    }
}