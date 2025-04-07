import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static class Pos {
        int x;
        int y;
        int c;

        public Pos(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        findEnemy(X, Y);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(board[A][B]).append(" ");
        }

        System.out.println(sb);
    }

    private static void findEnemy(int x, int y) {

        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(x, y, 0));

        while (!q.isEmpty()) {

            Pos p = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx <= 0 || ny <= 0 || nx > N || ny > N || board[nx][ny] != 0) {
                    continue;
                }

                board[nx][ny] = p.c+1;
                q.offer(new Pos(nx, ny, p.c+1));
            }
        }
    }
}