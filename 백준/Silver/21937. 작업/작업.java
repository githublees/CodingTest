import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] work;
    static int[] linkCnt;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        work = new List[N+1];

        for (int i = 1; i <= N; i++) {
            work[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            work[B].add(A);
        }

        int X = Integer.parseInt(br.readLine());
        System.out.println(bfs(X));
    }

    private static int bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.offer(x);
        visited[x] = true;

        int answer = 0;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (Integer nxt : work[now]) {
                if (visited[nxt]) {
                    continue;
                }
                q.offer(nxt);
                visited[nxt] = true;
                answer++;
            }
        }

        return answer;
    }
}