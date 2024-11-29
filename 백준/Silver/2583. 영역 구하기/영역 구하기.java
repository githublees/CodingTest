import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int M, N, K;
    static boolean[][] paper;
    static List<Integer> extent;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new boolean[M][N];
        
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    paper[y][x] = true;
                }
            }
        }

        extent = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (paper[y][x]) {
                    continue;
                }
                bfs(x, y);
            }
        }

        Collections.sort(extent);
        System.out.println(extent.size());
        for (int e : extent) {
            System.out.print(e + " ");
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        paper[y][x] = true;

        int count = 0;
        while (!q.isEmpty()) {

            Pos p = q.poll();

            count++;

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || paper[ny][nx]) continue;

                q.offer(new Pos(nx, ny));
                paper[ny][nx] = true;
            }
        }

        extent.add(count);
    }
}