import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] gem = new int[M];

        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            gem[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, gem[i]);
        }

        int answer = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < M; i++) {
                if (gem[i] % mid == 0) {
                    sum += gem[i] / mid;
                }
                else {
                    sum += gem[i] / mid + 1;
                }
            }

            if (sum > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}