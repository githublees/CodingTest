import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] d;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        d = new int[N][N];

        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            d[x][y] = 1;
            d[y][x] = 1;
        }

        Floyd();

        int answer = 0;
        int min = 100000000;

        for (int i = 0; i < N ; i++) {

            int result = 0;

            for (int j = 0; j < N; j++) {
                if (d[i][j] == 100000000) continue;
                result += d[i][j];
            }

            if (min > result) {
                min = result;
                answer = i;
            }
        }

        System.out.println(answer+1);
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) d[i][j] = 100000000;
            }
        }
    }

    public static void Floyd() {
        for (int m = 0; m < N ; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    d[s][e] = Math.min(d[s][e], d[s][m] + d[m][e]);
                }
            }
        }
    }
}