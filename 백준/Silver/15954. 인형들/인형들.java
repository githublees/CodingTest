import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static double answer = Double.MAX_VALUE;
    static int N, K;
    static int[] dolls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dolls = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = K; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                double m = getAvg(j, i);
                double n = getDeviation(j, i, m);
                answer = Math.min(answer, Math.sqrt(n));
            }
        }

        System.out.printf("%.11f%n", answer);

    }

    private static double getDeviation(int index, int k, double m) {
        double result = 0;
        for (int i = index - k; i < index; i++) {
            result += Math.pow((dolls[i] - m), 2);
        }
        return result / k;
    }

    private static double getAvg(int index, int k) {
        double sum = 0;
        for (int i = index - k; i < index; i++) {
            sum += dolls[i];
        }
        return sum / k;
    }
}