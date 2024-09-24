import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    static int minT = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs();

        System.out.println(minT);
        System.out.println(cnt);
    }

    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();

        int[] time = new int[100001];

        q.offer(N);
        time[N] = 1;

        while (!q.isEmpty()) {

            int now = q.poll();

            // now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (minT < time[now]) continue;

            for (int i = 0; i < 3; i++) {

                int next = now;

                if (i == 0) next += 1;
                else if (i == 1) next -= 1;
                else next *= 2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    minT = time[now];
                    cnt++;
                }

                /*
                 * 첫 방문이거나 (time[next] == 0)
                 * 이미 방문한 곳이어도 같은 시간에 방문했다면 (time[next] == time[now] + 1;
                 */
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    q.offer(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}