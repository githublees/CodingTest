import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, S, X, Y;
    static int[][] examiner;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pos implements Comparable<Pos> {
        final int x;
        final int y;
        final int type;
        final int second;

        public Pos(int x, int y, int type, int second) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.second = second;
        }

        @Override
        public int compareTo(Pos pos) {
            if (this.second == pos.second) {
                return this.type - pos.type;
            }
            return this.second - pos.second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        examiner = new int[N][N];

        PriorityQueue<Pos> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                examiner[i][j] = Integer.parseInt(st.nextToken());
                if (examiner[i][j] == 0) continue;
                pq.offer(new Pos(i, j, examiner[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        System.out.println(bfs(pq));
    }

    private static int bfs(PriorityQueue<Pos> pq) {

        while (!pq.isEmpty()) {

            Pos pos = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nx = pos.x + dx[d];
                int ny = pos.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || examiner[nx][ny] != 0 || pos.second >= S) continue;

                examiner[nx][ny] = pos.type;
                pq.offer(new Pos(nx, ny, pos.type, pos.second+1));
            }

//            print();
        }

        return examiner[X-1][Y-1];
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(examiner[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}