import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;

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
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        city = new List[n+1];

        for (int i = 1; i <= n; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            city[a].add(new Node(b, c));
        }

        for (int i = 1; i <= n; i++) {

            int[] dist = dijkstra(i);

            for (int j = 1; j <= n; j++) {

                if (dist[j] == Integer.MAX_VALUE) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(dist[j]).append(" ");
                }

            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[] dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];

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

        return dist;

    }
}