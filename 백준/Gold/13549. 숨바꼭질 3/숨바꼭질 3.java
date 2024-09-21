import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, answer = Integer.MAX_VALUE;
    static class Pos {

        int x;
        int t;

        public Pos (int x, int t) {
            this.x = x;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(answer);
    }

    private static void bfs(int start) {

        Queue<Pos> q = new LinkedList<>();

        boolean[] visited = new boolean[100001];

        q.offer(new Pos(start, 0));

        while (!q.isEmpty()) {

            Pos p = q.poll();

            visited[p.x] = true;

            if (p.x == K) {
                answer = Math.min(answer, p.t);
            }

            for (int i = 0; i < 3; i++) {

                int nx = p.x;
                int nt = p.t;

                switch (i) {
                    case 0 :
                        nx *= 2;
                        break;
                    case 1 :
                        nx += 1;
                        nt += 1;
                        break;
                    case 2 :
                        nx -= 1;
                        nt += 1;
                }

                if (nx < 0 || nx >= 100001 || visited[nx]) continue;

                q.offer(new Pos(nx, nt));
            }
        }
    }
}