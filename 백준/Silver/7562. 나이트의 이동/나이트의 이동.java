import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상 상 하 하 좌 좌 우 우
    static int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
    static int[] dy = {2, 2, -2, -2, -1, 1, -1, 1};

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
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(I, startX, startY, endX, endY));
        }
    }

    private static int bfs(int I, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[I][I];
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (p.x == endX && p.y == endY) {
                return p.d;
            }

            for (int d = 0; d < 8; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I || visited[nx][ny]) continue;

                q.offer(new Pos(nx, ny, p.d+1));
                visited[nx][ny] = true;
            }
        }

        return 0;
    }
}