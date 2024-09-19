import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer = 0;

    static int[][] map;

    static List<Pos> wall;

    static int[] dx = {-1, 1, 0 , 0};
    static int[] dy = {0, 0, -1 , 1};

    static class Pos {
        int x;
        int y;
        int d;
        boolean state;

        public Pos (int x, int y, int d, boolean state) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.state = state;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        wall = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            String[] str = br.readLine().split("");

            for (int j = 0; j < M; j++) {

                map[i][j] = Integer.parseInt(str[j]);

            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visited = new boolean[2][N][M];

        q.offer(new Pos(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                return p.d;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                // 벽을 부순적이 있을 경우
                if (p.state) {

                    // 해당 지점이 벽이 아니고 방문한 적이 없다면
                    if (map[nx][ny] == 0 && !visited[1][nx][ny]) {
                        visited[1][nx][ny] = true;
                        q.offer(new Pos(nx, ny, p.d+1, true));
                    }

                }
                // 벽을 부순적이 없는 경우
                else {

                    // 해당 위치가 벽이라면
                    if (map[nx][ny] == 1) {

                        // 벽을 부수고 값을 넣는다.
                        visited[1][nx][ny] = true;
                        q.offer(new Pos(nx, ny, p.d + 1, true));

                    }
                    // 벽이 아니고 방문한 적도 없다면
                    else if (!visited[0][nx][ny]) {

                        visited[0][nx][ny] = true;
                        q.offer(new Pos(nx, ny, p.d + 1, false));

                    }
                }
            }
        }

        return -1;
    }
}