import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{

    static int N, min = Integer.MAX_VALUE;

    static int[] solution;

    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        binarySearch();

    }

    private static void binarySearch() {

        for (int i = 0; i < N; i++) {

            int left = i + 1;
            int right = N -1;

            while (left <= right) {

                int mid = (left + right) / 2;

                int sum = solution[i] + solution[mid];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer[0] = solution[i];
                    answer[1] = solution[mid];
                }

                if (sum < 0) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }

            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}