import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] solution;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        System.out.println(binarySearch());
    }

    private static int binarySearch() {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            int start = i + 1;
            int end = N - 1;

            while (start <= end) {

                int mid = (end + start) / 2;
                int sum = solution[i] + solution[mid];

                if (Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                }

                if (sum < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return min;
    }
}