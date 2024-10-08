import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] build;
    static int[] buildTime, linkCnt;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            buildTime = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            dp = new int[N+1];

            build = new List[N+1];
            for (int i = 1; i <= N; i++) {
                build[i] = new ArrayList<>();
            }

            linkCnt = new int[N+1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                build[X].add(Y);
                linkCnt[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            bfs(N);

            sb.append(dp[W]).append("\n");

        }

        System.out.println(sb);
    }

    private static void bfs(int N) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (linkCnt[i] == 0) {
                dp[i] = buildTime[i-1];
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int nxt : build[now]) {

                dp[nxt] = Math.max(dp[now] + buildTime[nxt-1], dp[nxt]);
                linkCnt[nxt]--;

                if (linkCnt[nxt] == 0) {
                    q.offer(nxt);
                }

            }
        }
    }
}