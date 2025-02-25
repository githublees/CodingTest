import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] A;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos {
        int x;
        int y;
        int d;

        public Pos(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];

        int start_x = 0, start_y = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = str.charAt(j) -'0';
                if (A[i][j] == 2) {
                    start_x = i;
                    start_y = j;
                }
            }
        }

        System.out.println(bfs(start_x, start_y));
    }

    static String bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new Pos(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (A[p.x][p.y] == 3 || A[p.x][p.y] == 4 || A[p.x][p.y] == 5) {
                return "TAK" + "\n" + p.d;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || A[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }

                q.offer(new Pos(nx, ny, p.d+1));
                visited[nx][ny] = true;
            }
        }

        return "NIE";
    }
}