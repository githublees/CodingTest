import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, start_x, start_y;
    static int[][] map, result;
    static boolean[][] visited;

    static class Pos {
        int x;
        int y;
        int dis;

        public Pos (int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start_x = i;
                    start_y = j;
                }

                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        bfs(start_x, start_y);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    sb.append(-1).append(" ");
                    continue;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y, 0));
        result[x][y] = 0;
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pos p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                int nd = p.dis + 1;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] != 1) continue;

                q.offer(new Pos(nx, ny, nd));
                visited[nx][ny] = true;
                result[nx][ny] = nd;
            }
        }
    }
}