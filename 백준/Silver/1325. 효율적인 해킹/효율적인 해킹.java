import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int max = 0;
    static List<Integer>[] graph;
    static int[] computer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        computer = new int[N+1];
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
        }

        for (int start = 1; start <= N; start++) {
            visited = new boolean[N+1];
            bfs(start);
        }

        for (int number = 1; number <= N; number++) {
            if (max == computer[number]) {
                System.out.print(number + " ");
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int next : graph[now]) {

                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    max = Math.max(max, ++computer[next]);
                }
            }
        }
    }
}