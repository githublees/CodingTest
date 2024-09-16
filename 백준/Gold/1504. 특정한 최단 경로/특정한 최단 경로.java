import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] graph;

    static int N, E;

    static class Node implements Comparable<Node> {

        int e;
        int n;

        public Node (int e, int n) {
            this.e = e;
            this.n = n;
        }

        @Override
        public int compareTo(Node n) {
            return this.n - n.n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result = 0;
        result += dijkstra(1, v1);
        result += dijkstra(v1, v2);
        result += dijkstra(v2, N);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        if (result >= 200000 * 1000 && result2 >= 200000 * 1000) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result, result2));
        }
    }

    private static int dijkstra(int s, int e) {

        int[] dist = new int[N+1];

        Arrays.fill(dist, 200000 * 1000);

        boolean[] visited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {

            Node node = pq.poll();

            if (visited[node.e]) continue;

            visited[node.e] = true;

            for (int i = 0; i < graph[node.e].size(); i++) {
                Node nnd = graph[node.e].get(i);

                if (dist[nnd.e] > nnd.n + node.n) {
                    dist[nnd.e] = nnd.n + node.n;
                    pq.offer(new Node(nnd.e,  dist[nnd.e]));
                }
            }
        }

        return dist[e];
    }
}