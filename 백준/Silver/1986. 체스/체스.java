import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] qx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] qy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int[] kx = {-2, -2, -1, 1, 2, 2, -1, 1};
    static int[] ky = {-1, 1, -2, -2, -1, 1, 2, 2};

    static class Horse {
        char type;
        int x;
        int y;

        public Horse(char type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n+1][m+1];

        List<Horse> list = new ArrayList<>();

        st =  new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Horse('Q', x, y));
            board[x][y] ='Q';
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Horse('K', x, y));
            board[x][y] = 'K';
        }

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 'P';
        }

        System.out.println(bfs(list, board, n, m));
    }

    private static int bfs(List<Horse> list, char[][] board, int n, int m) {

        for (Horse h : list) {

            if (h.type == 'Q') {

                for (int d = 0; d < 8; d++) {
                    int nx = h.x + qx[d];
                    int ny = h.y + qy[d];

                    while (nx >= 1 && ny >= 1 && nx <= n && ny <= m && board[nx][ny] != 'P' && board[nx][ny] != 'Q' && board[nx][ny] != 'K') {
                        board[nx][ny] = '1';
                        nx += qx[d];
                        ny += qy[d];
                    }
                }
            }
            else if (h.type == 'K') {

                for (int d = 0; d < 8; d++) {
                    int nx = h.x + kx[d];
                    int ny = h.y + ky[d];

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                        if (board[nx][ny] == '\u0000') {
                            board[nx][ny] = '1';
                        }
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == '\u0000') {
                    answer++;
                }
            }
        }

        return answer;
    }
}