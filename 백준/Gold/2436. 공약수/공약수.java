import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int G, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        G = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        long mul = (long) G * L;
        long setA = 0, setB = 0;
        for (int i = G; i <= Math.sqrt(mul); i+= G) {
            if (mul % i == 0 && gcd(i, mul / i) == G) {
                setA = i;
                setB = mul / i;
            }
        }
        System.out.println(setA + " " + setB);

    }

    private static long gcd(long a, long b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}