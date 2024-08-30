import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int p = q.poll();

            for (int np : list[p]) {
                if (visited[np]) continue;

                q.offer(np);
                visited[np] = true;
            }
        }
    }
}