import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int answer = Integer.MAX_VALUE;
        int left = 0, right= 0;

        while (left <= right) {

            int abs = Math.abs(numbers[left] - numbers[right]);

            if (abs >= M) {
                answer = Math.min(answer, abs);
            }

            if (right < N - 1 && abs < M) {
                right++;
            }
            else {
                left++;
            }
        }

        System.out.println(answer);
    }
}