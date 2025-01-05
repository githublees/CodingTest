import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Bomb> q;

    static class Bomb {
        int x;
        int y;
        int t;

        public Bomb(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'O') {
                    q.offer(new Bomb(i, j, 1));
                }
            }
        }

        progress();
        print();
    }

    private static void progress() {
        for (int time = 1; time <= N; time++) {
            if (time != 1) {
                install();
            }
            bombCheck();
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void bombCheck() {
        int size = q.size();
        boolean[][] range = new boolean[R][C];
        while (size --> 0) {

            Bomb bomb = q.poll();

            if (bomb.t == 3) {
                explosion(bomb.x, bomb.y, range);
            } else {
                if (range[bomb.x][bomb.y]) {
                    map[bomb.x][bomb.y] = '.';
                }
                else {
                    q.offer(new Bomb(bomb.x, bomb.y, bomb.t + 1));
                }
            }
        }
    }

    private static void explosion(int x, int y, boolean[][] range) {
        map[x][y] = '.';
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            range[nx][ny] = true;
            map[nx][ny] = '.';
        }
    }

    private static void install() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    q.offer(new Bomb(i, j, 0));
                    map[i][j] = 'O';
                }
            }
        }
    }
}