import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static List<Node>[] city;

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node (int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo (Node n) {
            return this.weight - n.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        city = new List[N+1];

        for (int i = 1; i <= N; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            city[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.index]) continue;

            visited[now.index] = true;

            for (Node nxt : city[now.index]) {

                if (dist[nxt.index] > dist[now.index] + nxt.weight) {
                    dist[nxt.index] = dist[now.index] + nxt.weight;
                    pq.offer(new Node(nxt.index, dist[nxt.index]));
                }
            }
        }

        return dist[end];
    }
}