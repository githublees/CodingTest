import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static int white = 0, blue = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                bfs(i, j, map[i][j]);
            }
        }

        System.out.println(white + " " + blue);
    }

    private static void bfs(int x, int y, char color) {

        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        visited[x][y] = true;

        int count = 0;
        while (!q.isEmpty()) {

            Pos p = q.poll();

            count++;

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= M || ny >= N ||
                        visited[nx][ny] || color != map[nx][ny]) continue;

                q.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if (color == 'W') {
            white += count * count;
        }
        else {
            blue += count * count;
        }
    }
}