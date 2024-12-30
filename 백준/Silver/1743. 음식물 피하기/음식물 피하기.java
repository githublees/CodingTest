import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = 0, count = 0;
    static int N, M, K;
    static int[][] map;
    static boolean[][] done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        done = new boolean[N+1][M+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (done[r][c]) continue;
                count = 0;
                dfs(r, c);
            }
        }

        System.out.println(max);
    }

    private static void dfs(int r, int c) {

        if (r < 1 || c < 1 || r > N || c > M || done[r][c] || map[r][c] == 0) {
            return;
        }

        done[r][c] = true;
        count++;
        max = Math.max(max, count);

        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c + 1);
        dfs(r, c - 1);
    }
}