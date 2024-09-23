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
        public int compareTo (Node n) {
            return this.weight - n.weight;
        }
    }

    static List<Node>[] city;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        city = new List[n+1];

        for (int i = 0; i < n; i++) {
            city[i+1] = new ArrayList<>();
        }

        while (m --> 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            city[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

    }

    private static void dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        int[] route = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (visited[now.index]) continue;

            visited[now.index] = true;

            for (Node nxt : city[now.index]) {

                if (dist[nxt.index] > dist[now.index] + nxt.weight) {
                    dist[nxt.index] = dist[now.index] + nxt.weight;
                    route[nxt.index] = now.index;
                    pq.offer(new Node(nxt.index, dist[nxt.index]));
                }

            }
        }

        isPrint(end, dist, route);
    }

    private static void isPrint(int end, int[] dist, int[] route) {

        Stack<Integer> stack = new Stack<>();

        System.out.println(dist[end]);

        while (end != 0) {
            stack.push(end);
            end = route[end];
        }

        System.out.println(stack.size());

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}