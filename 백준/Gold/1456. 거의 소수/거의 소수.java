import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        boolean[] almostPrime = new boolean[(int) Math.sqrt(B)+1];

        for (int i = 2; i < almostPrime.length; i++) {

            if (almostPrime[i]) {
                continue;
            }

            for (int j = i * 2; j < almostPrime.length; j+=i) {
                almostPrime[j] = true;
            }
        }

        int answer = 0;

        for (int i = 2; i < almostPrime.length; i++) {

            if (almostPrime[i]) {
                continue;
            }

            long temp = i;

            while (temp <= (double) B / i) {
                if (temp >= (double) A / i) {
                    answer++;
                }
                temp *= i;
            }
        }

        System.out.println(answer);
    }
}