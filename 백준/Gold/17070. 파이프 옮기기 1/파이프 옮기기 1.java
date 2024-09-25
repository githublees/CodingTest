import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    static class Pos {
        int x;
        int y;
        int dir;

        public Pos (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
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

        if (map[N-1][N-1] == 1) {
            System.out.println(0);
            return;
        }
        
        System.out.println(bfs());

    }

    private static int bfs() {

        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(0, 1, 0));

        int answer = 0;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (p.x == N-1 && p.y == N-1) {
                answer++;
                continue;
            }

            for (int i = 0; i < 3; i++) {

                if ((p.dir == 0 && i == 1) || (p.dir == 1 && i == 0)) continue;

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N ) continue;

                if (map[nx][ny] == 1 || (i == 2 && (map[nx-1][ny] == 1 || map[nx][ny-1] == 1))) continue;

                q.offer(new Pos(nx, ny, i));
            }
        }

        return answer;
    }
}