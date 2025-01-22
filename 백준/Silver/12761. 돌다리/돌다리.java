import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A, B, N, M;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dx = new int[]{-1, 1, A, B, -A, -B, A, B};

        bfs();
    }

    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        q.offer(N);
        visited[N] = 0;

        while (!q.isEmpty()) {

            int p = q.poll();

            if (p == M) {
                System.out.println(visited[p]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx;

                if (i >= 6) {
                    nx = p * dx[i];
                }
                else {
                    nx = p + dx[i];
                }

                if (nx < 0 || nx > 100000 || visited[nx] <= visited[p] + 1) {
                    continue;
                }

                q.offer(nx);
                visited[nx] = visited[p] + 1;
            }
        }
    }
}