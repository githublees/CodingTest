import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, result = Integer.MIN_VALUE;
    static int[] dx ={-1, 1, 0, 0};
    static int[] dy ={0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0, 0, 0);

        System.out.println(result);
    }

    private static void solution(int x, int y, int k, int sum) {

        if (k == K) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check(i, j)) {
                    continue;
                }

                visited[i][j] = true;
                solution(i, j, k+1, sum + map[i][j]);
                visited[i][j] = false;
            }
        }
    }

    private static boolean check(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (visited[x][y] || visited[nx][ny]) {
                return true;
            }
        }
        return false;
    }
}