import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    static class Pos {
        int r;
        int c;
        int d;

        public Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r1, c1, r2, c2));
    }

    private static int bfs(int r1, int c1, int r2, int c2) {

        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new Pos(r1, c1, 0));
        visited[r1][c1] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();
            
            if (p.r == r2 && p.c == c2) {
                return p.d;
            }

            for (int d = 0; d < 6; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
                    continue;
                }

                q.offer(new Pos(nr, nc, p.d + 1));
                visited[nr][nc] = true;
            }
        }

        return -1;
    }
}