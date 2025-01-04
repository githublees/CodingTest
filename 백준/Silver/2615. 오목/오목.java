import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0, count = 0;
    static int[] position = new int[2];

    static int[][] board = new int[20][20];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1}; // 상, 하, 좌, 우, 좌상, 우하, 좌하, 우상
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
               board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 19; i++) {

            for (int j = 1; j <= 19; j++) {

                if (board[i][j] == 0) {
                    continue;
                }

                for (int d = 7; d >= 0; d-=2) {
                    visited = new boolean[20][20];
                    count = 0;
                    dfs(i, j, board[i][j], d);

                    if (count == 5) {
                        System.out.println(answer);

                        if (i < position[0] && j > position[1]) {
                            System.out.println(position[0] + " " + position[1]);
                        } else {
                            System.out.println(i + " " + j);
                        }
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static void dfs(int x, int y, int color, int d) {

        if (x < 1 || y < 1 || x >= 20 || y >= 20 || board[x][y] == 0 || board[x][y] != color || visited[x][y]) {
            return;
        }

        count++;
        visited[x][y] = true;

        answer = color;
        position[0] = x;
        position[1] = y;

        dfs(x + dx[d], y + dy[d], color, d);
        dfs(x + dx[d-1], y + dy[d-1], color, d);
    }
}