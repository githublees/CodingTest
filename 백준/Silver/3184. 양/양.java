import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int sheep = 0, wolf = 0;
    static int R, C;
    static char[][] map;
    static boolean[][] done;

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

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        done = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (done[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(x, y));

        int o = 0, v = 0;
        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (map[p.x][p.y] == 'o') {
                o++;
            } else if (map[p.x][p.y] == 'v') {
                v++;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C
                        || done[nx][ny] || map[nx][ny] == '#') {
                    continue;
                }

                q.offer(new Pos(nx, ny));
                done[nx][ny] = true;
            }
        }

        if (o > v) {
            sheep += o;
        } else {
            wolf += v;
        }
    }
}