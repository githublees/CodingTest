import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node (int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo (Node node) {
            return this.weight - node.weight;
        }

    }
    static List<Node>[] location;

    static int n, m, r, answer = 0;

    static int[] item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        location = new List[n+1];
        item = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n+1; i++) {
            location[i] = new ArrayList<>();
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            location[a].add(new Node(b, l));
            location[b].add(new Node(a, l));
        }

        for (int i = 1; i < n+1; i++) {

            int[] dist = dijkstra(i);

            int itemCnt = 0;

            for (int j = 1; j < dist.length; j++) {
                if (dist[j] <= m) {
                    itemCnt += item[j];
                }
            }

            answer = Math.max(answer, itemCnt);
        }

        System.out.println(answer);

    }

    private static int[] dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.index]) continue;

            visited[now.index] = true;

            for (Node nxt : location[now.index]) {

                if (dist[nxt.index] > dist[now.index] + nxt.weight) {
                    dist[nxt.index] = dist[now.index] + nxt.weight;
                    pq.offer(new Node(nxt.index, dist[nxt.index]));
                }
            }
        }

        return dist;
    }
}