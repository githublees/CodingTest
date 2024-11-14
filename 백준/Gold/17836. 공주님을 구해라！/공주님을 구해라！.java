import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int N, M, T;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos {
        int x;
        int y;
        int t;
        int sword;

        public Pos(int x, int y, int t, int sword) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.sword = sword;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0) ? answer : "Fail");
    }

    private static boolean bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[2][N][M];

        q.offer(new Pos(x, y, 0, 0));
        visited[0][x][y] = true;

        while (!q.isEmpty()) {
            Pos p = q.poll();

            if (p.x == N-1 && p.y == M-1 && p.t <= T) {
                answer = Math.min(answer, p.t);
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (p.sword == 0) {

                    if (map[nx][ny] == 1 || visited[p.sword][nx][ny]) continue;

                    if (map[nx][ny] == 2) {
                        q.offer(new Pos(nx, ny, p.t+1, 1));
                    }
                    else {
                        q.offer(new Pos(nx, ny, p.t+1, 0));
                    }
                }
                else {

                    if (visited[p.sword][nx][ny]) continue;

                    q.offer(new Pos(nx, ny, p.t+1, p.sword));
                }

                visited[p.sword][nx][ny] = true;
            }
        }
        return false;
    }
}