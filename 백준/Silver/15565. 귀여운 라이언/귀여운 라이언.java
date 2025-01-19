import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

        int answer = Integer.MAX_VALUE;
        int left = 0, right = 0, count = 0;

        while (left <= right) {

            if (count < K && right < N) {

                if (dolls[right++] == 1) {
                    count++;
                }

            } else {

                if (dolls[left++] == 1) {
                    count--;
                }

                if (left >= N) {
                    break;
                }

            }

            if (count >= K) {
                answer = Math.min(answer, right - left);
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}