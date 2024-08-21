import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos {
        int n;
        int t;

        public Pos(int n, int t) {
            this.n = n;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(N, 0));
        visited[N] = true;


        while(!q.isEmpty()) {
            Pos p = q.poll();

            if (p.n == K) {
                System.out.println(p.t);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nn = p.n;
                int nt = p.t + 1;

                if (i == 0) {
                    nn += 1;
                } else if (i == 1) {
                    nn -= 1;
                } else if (i == 2) {
                    nn *= 2;
                }

                if (nn < 0 || nn > 100000 || visited[nn]) continue;

                q.offer(new Pos(nn, nt));
                visited[nn] = true;
            }
        }
    }
}