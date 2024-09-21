import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        tree = new List[N+1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int[] parent = bfs();

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }


        System.out.println(sb);
    }

    private static int[] bfs() {
        int[] parent = new int[N+1];

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {

            int index = q.poll();

            for (int node : tree[index]) {

                if (visited[node]) continue;

                visited[node] = true;
                q.offer(node);
                parent[node] = index;

            }
        }

        return parent;
    }
}