import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D_1 = Integer.parseInt(st.nextToken());
        int D_2 = Integer.parseInt(st.nextToken());

        long answer = 0;
        boolean[][] seat = new boolean[D_2+1][D_2+1];

        for (int i = D_1; i <= D_2; i++) {

            for (int j = 1; j <= i; j++) {

                int gcd = findGcd(i, j);
                int m = i / gcd;
                int n = j / gcd;

                if (!seat[m][n]) {
                    answer++;
                    seat[m][n] = true;
                }

            }
        }

        System.out.println(answer);
    }

    private static int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a%b);
    }
}