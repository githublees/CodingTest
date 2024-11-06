import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] student = new int[N];
        int[] diff = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            diff[i] = student[i+1] - student[i];
        }

        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < N-K; i++) {
            answer += diff[i];
        }

        System.out.println(answer);

    }
}