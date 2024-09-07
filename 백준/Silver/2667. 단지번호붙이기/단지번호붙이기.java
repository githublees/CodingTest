import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N, total = 0;

    static class Pos {
        int x;
        int y;

        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }

        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j] || map[i][j] == 0) continue;

                total++;
                count.add(bfs(i, j));

            }
        }
        Collections.sort(count);

        sb.append(total).append("\n");
        for (int n : count) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        int house = 0;

        q.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            house++;

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }
        }

        return house;
    }
}