import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static int C, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        C = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        list = new List[C+1];
        for (int i = 1; i < C+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[C+1];

        q.offer(start);
        visited[start] = true;

        int answer = 0;
        while (!q.isEmpty()) {

            int node = q.poll();

            for (int v : list[node]) {

                if (visited[v]) continue;

                q.offer(v);
                visited[v] = true;
                answer++;
            }
        }

        return answer;
    }
}