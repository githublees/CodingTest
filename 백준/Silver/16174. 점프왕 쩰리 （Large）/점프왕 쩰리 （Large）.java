import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

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

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new Pos(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (map[p.x][p.y] == -1) {
                return "HaruHaru";
            }

            for (int i = 0; i < 2; i++) {
                int nx = p.x + (dx[i] * map[p.x][p.y]);
                int ny = p.y + (dy[i] * map[p.x][p.y]);
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }
                
                q.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }
        
        return "Hing";
    }
}