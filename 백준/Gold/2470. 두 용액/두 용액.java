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
        
        binarySearch();
    }

    private static void binarySearch() {

        int max = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < N; i++) {

            int start = i + 1;
            int end = N - 1;

            while (start <= end) {

                int mid = (end + start) / 2;
                int sum = solution[i] + solution[mid];

                if (max > Math.abs(sum)) {
                    max = Math.abs(sum);
                    result[0] = solution[i];
                    result[1] = solution[mid];
                }

                if (sum < 0) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }

            }
        }

        System.out.println(result[0] + " " + result[1]);

    }
}