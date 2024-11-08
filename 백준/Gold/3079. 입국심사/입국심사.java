import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long MAX_VALUE;
    static long answer = 0;
    static long[] table;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new long[N];

        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(table);

        MAX_VALUE = M * table[N-1];

        binarySearch();

        System.out.println(answer);

    }

    private static void binarySearch() {

        long left = 0;
        long right = MAX_VALUE;

        while (left <= right) {

            long mid = (left + right) / 2;

            long people = 0;
            for (int i = 0; i < N; i++) {

                if (people >= M) break;

                people += mid / table[i];
            }

            if (people >= M) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
    }
}