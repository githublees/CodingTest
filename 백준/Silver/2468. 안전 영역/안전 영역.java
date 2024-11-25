import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int answer = 1;

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

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 100; i++) {
            answer = Math.max(answer, bfs(i));
        }

        System.out.println(answer);
    }

    private static int bfs(int h) {

        int count = 0;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= h) {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }

                Queue<Pos> q = new LinkedList<>();

                q.offer(new Pos(i, j));
                visited[i][j] = true;
                count++;

                while (!q.isEmpty()) {

                    Pos p = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = p.x + dx[d];
                        int ny = p.y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                            continue;
                        }

                        q.offer(new Pos(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return count;
    }
}