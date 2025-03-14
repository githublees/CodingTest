import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, X, answer = 0;
    static int[] problem;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        problem = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < (1 << N); i++) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {

                if ((i & 1 << j) != 0) {
                    sum += problem[j];
                    max = Math.max(max, problem[j]);
                    min = Math.min(min, problem[j]);
                }
            }

            if (sum < L || sum > R) {
                continue;
            }
            
            if (max - min < X) {
                continue;
            }
            
            answer++;
        }

        System.out.println(answer);
    }
}