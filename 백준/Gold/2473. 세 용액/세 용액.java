import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long min = Long.MAX_VALUE;
    static long[] solution;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = new long[3];
        solution = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(solution);

        binarySearch();

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    private static void binarySearch() {

        for (int i = 0; i < N-2; i++) {

            int start = i;
            int center = i + 1;
            int end = N - 1;

            while (center < end) {

                long sum = solution[start] + solution[center] + solution[end];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    answer[0] = solution[start];
                    answer[1] = solution[center];
                    answer[2] = solution[end];
                }

                if (sum < 0) {
                    center++;
                }
                else if (sum > 0) {
                    end--;
                }
                else {
                    break;
                }

            }
        }
    }
}