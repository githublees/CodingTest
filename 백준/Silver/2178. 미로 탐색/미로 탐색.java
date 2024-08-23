import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int N, M, answer = 0;

    static class Pos {
        int x;
        int y;
        int m;

        public Pos(int x, int y, int m) {
            this.x = x;
            this.y = y;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0, 1));

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (p.x == N-1 && p.y == M-1) {
                return p.m;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new Pos(nx, ny, p.m+1));
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}