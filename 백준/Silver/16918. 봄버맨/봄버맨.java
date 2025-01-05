import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = -1;
                }
                else {
                    map[i][j] = 1;
                }
            }
        }

        progress();
        print();
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    System.out.print('.');
                } else {
                    System.out.print('O');
                }
            }
            System.out.println();
        }
    }

    private static void progress() {

        for (int time = 1; time <= N; time++) {
            if (time != 1) {
                install();
            }
            bombCheck();
        }
    }

    private static void bombCheck() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    continue;
                }

                if (map[i][j] == 3) {
                    explosion(i, j);
                }
                else {
                    map[i][j]++;
                }
            }
        }
    }

    private static void explosion(int x, int y) {
        map[x][y] = -1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 3) {
                continue;
            }

            map[nx][ny] = -1;
        }
    }

    private static void install() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                }
            }
        }
    }
}