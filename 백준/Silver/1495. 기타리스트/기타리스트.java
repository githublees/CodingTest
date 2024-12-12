import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M;
    static int[] V;
    static long[][] DP;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = new int[N+1];
        DP = new long[N+1][M+1]; // [곡 순서][볼륨]

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        DP[0][S] = 1; // [시작][초기볼륨]

        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <= M; v++) {

                if (DP[i - 1][v] > 0) {
                    int pv = v + V[i];
                    int mv = v - V[i];

                    if (pv <= M) {
                        DP[i][pv] += DP[i - 1][v];
                    }
                    if (mv >= 0) {
                        DP[i][mv] += DP[i - 1][v];
                    }
                }
            }
        }

        for (int v = 0; v <= M; v++) {
            if (DP[N][v] > 0) {
                answer = Math.max(answer, v);
            }
        }

        System.out.println(answer);
    }
}