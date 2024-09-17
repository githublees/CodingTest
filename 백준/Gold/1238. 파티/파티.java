import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    static int N, M, X;

    static List<Node>[] graph, r_graph;

    static class Node implements Comparable<Node> {

        int edge;

        int weight;

        public Node (int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }

        @Override
        public int compareTo (Node n) {
            return this.weight - n.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        r_graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            r_graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, T));
            r_graph[B].add(new Node(A, T));

        }

        int[] AtoB = dijkstra(graph);
        int[] BtoA = dijkstra(r_graph);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, AtoB[i] + BtoA[i]);
        }

        System.out.println(answer);
    }

    public static int[] dijkstra(List<Node>[] list) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, INF);

        pq.offer(new Node(X, 0));
        dist[X] = 0;

        while (!pq.isEmpty()) {

            Node node = pq.poll();

            if (visited[node.edge]) continue;

            visited[node.edge] = true;

            for (Node nxt : list[node.edge]) {

                if (dist[nxt.edge] > dist[node.edge] + nxt.weight) {
                    dist[nxt.edge] = dist[node.edge] + nxt.weight;
                    pq.offer(new Node(nxt.edge, dist[nxt.edge]));

                }
            }
        }

        return dist;

    }
}