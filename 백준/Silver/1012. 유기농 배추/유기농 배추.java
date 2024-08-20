import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

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

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            int answer = 0;
            List<Pos> pos = new ArrayList<>();

            while (K --> 0) {

                StringTokenizer xy = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(xy.nextToken());
                int Y = Integer.parseInt(xy.nextToken());

                map[Y][X] = 1;
                pos.add(new Pos(X, Y));
            }

            boolean[][] visited = new boolean[N][M];

            for (Pos start : pos) {

                if (visited[start.y][start.x]) continue;

                visited[start.y][start.x] = true;

                Queue<Pos> q = new LinkedList<>();
                q.offer(new Pos(start.x, start.y));

                answer += 1;

                while (!q.isEmpty()) {

                    Pos p = q.poll();

                    for (int d=0; d<4; d++) {

                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx] || map[ny][nx] == 0) continue;

                        q.offer(new Pos(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}