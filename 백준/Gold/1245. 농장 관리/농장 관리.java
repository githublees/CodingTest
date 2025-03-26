import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static boolean[][] done;
    static boolean[][] visted;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMountainPeak());
    }

    private static int getMountainPeak() {

        int answer = 0;

        done = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (done[i][j]) {
                    continue;
                }

                if (findMountainPeak(i, j)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean findMountainPeak(int x, int y) {

        List<Pair> land = new ArrayList<>();
        Queue<Pair> mountain = new LinkedList<>();

        mountain.add(new Pair(x, y));
        done[x][y] = true;

        while (!mountain.isEmpty()) {

            Pair p = mountain.poll();

            land.add(p);

            for (int d = 0; d < 8; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (isValidation(nx, ny) || map[p.x][p.y] != map[nx][ny] || done[nx][ny]) {
                    continue;
                }

                mountain.add(new Pair(nx, ny));
                done[nx][ny] = true;
            }
        }

        return isMountainPeak(land);
    }

    private static boolean isMountainPeak(List<Pair> land) {

        for (Pair pair : land) {
            for (int d = 0; d < 8; d++) {
                int nx = pair.x + dx[d];
                int ny = pair.y + dy[d];

                if (isValidation(nx, ny)) {
                    continue;
                }

                if (map[pair.x][pair.y] < map[nx][ny]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidation(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
}