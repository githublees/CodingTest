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
        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int start = -1;
        int end = 0;

        int now = 0;
        while (end < N) {

            if (now == M) {
                answer++;
            }

            if (start == N-1) {
                now -= input[end++];

            } else if (start == end) {
                now += input[++start];

            } else if (now <= M) {
                now += input[++start];

            } else if (now > M) {
                now -= input[end++];
            }

        }

        System.out.println(answer);
    }
}