import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Node>[] graph;

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(new Node(1, 0));
        dist[1] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.index]) continue;
            visited[now.index] = true;

            for (Node nxt : graph[now.index]) {
                if (dist[nxt.index] > dist[now.index] + nxt.weight) {
                    dist[nxt.index] = dist[now.index] + nxt.weight;
                    q.offer(new Node(nxt.index, dist[nxt.index]));
                }
            }
        }

        return dist[N];
    }
}