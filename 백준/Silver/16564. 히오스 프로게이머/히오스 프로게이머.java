import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] level;
    static long max = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        level = new int[N];

        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
            max = Math.min(max, level[i]);
        }

        binarySearch();

        System.out.println(max);
    }

    private static void binarySearch() {

        long start = max;
        long end = start + K;

        while (start <= end) {

            long mid = (start + end) / 2;

            long answer = 0;

            for (int i = 0; i < N; i++) {
                if (level[i] <= mid) {
                    answer += mid - level[i];
                }
            }

            if (answer <= K) {
                max = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}