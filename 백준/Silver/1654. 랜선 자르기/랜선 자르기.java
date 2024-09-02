import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] wires;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long max = 0, min = 0;
        wires = new int[K];
        for (int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());

            if (max < wires[i]) {
                max = wires[i];
            }
        }

        max++;

        BinarySearch(min, max);
    }

    private static void BinarySearch(long min, long max) {

        while (min < max) {

            long mid = (min + max) / 2;
            long num = 0;

            for (int wire : wires) {

                num += (wire / mid);

            }

            if (num < N) {

                max = mid;

            } else {

                min = mid + 1;

            }
        }

        System.out.println(min - 1);
    }
}