import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X, Y;
    static String[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Pos {
        int x;
        int y;
        int t;

        public Pos (int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        map = new String[X][Y];

        for (int i = 0; i < X; i++) {
            map[i] = br.readLine().split("");
        }

        int answer = 0;

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {

                if (map[i][j].equals("W")) continue;

                answer = Math.max(answer, bfs(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int x, int y) {

        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[X][Y];
        int max = 0;

        q.offer(new Pos(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            max = Math.max(max, p.t);

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y || visited[nx][ny] || map[nx][ny].equals("W")) continue;

                q.offer(new Pos(nx, ny, p.t+1));
                visited[nx][ny] = true;
            }
        }
        return max;
    }
}