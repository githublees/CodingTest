import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int r, c, d;
    static int answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        isMoveRobot(r, c, d);

        System.out.println(answer);
    }

    private static void isMoveRobot(int r, int c, int d) {

        while (true) {
            // 현재 칸 청소
            if (!visited[r][c]) {
                visited[r][c] = true;
                answer++;
            }

            // 주변 4칸 중 청소되지 않은 칸이 없는 경우
            if (!isCheckTrash(r, c)) {

                int br;
                int bc;

                if (d == 0) {
                    br = r + dx[2];
                    bc = c + dy[2];
                } else if (d == 1) {
                    br = r + dx[3];
                    bc = c + dy[3];
                } else if (d == 2) {
                    br = r + dx[0];
                    bc = c + dy[0];
                } else {
                    br = r + dx[1];
                    bc = c + dy[1];
                }

                // 후진한 방향이 맵을 벗어나거나 맵이 1이면 작동 정지
                if (isValidation(br, bc) || map[br][bc] == 1) return;

                r = br;
                c = bc;

            }
            else {

                int fr;
                int fc;

                while (true) {
                    // 반시계 방향으로 90도 회전
                    d = (d + 3) % 4;

                    // 바라보는 방향을 기준으로
                    fr = r + dx[d];
                    fc = c + dy[d];

                    // 맵을 벗어나거나 청소된 곳이면
                    if (isValidation(fr, fc) || visited[fr][fc]) continue;

                    // 청소된 곳이라면
                    break;
                }

                r = fr;
                c = fc;
            }
        }
    }

    private static boolean isCheckTrash (int r, int c) {

        for (int i = 0; i < 4; i++) {

            int nx = r + dx[i];
            int ny = c + dy[i];

            // 맵을 벗어나거나 청소한 곳이면 continue;
            if (isValidation(nx, ny) || visited[nx][ny]) continue;

            // 하나라도 청소한 곳이 아니면 true;
            return true;
        }

        return false;
    }

    private static boolean isValidation(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
            return true;
        }
        return false;
    }
}