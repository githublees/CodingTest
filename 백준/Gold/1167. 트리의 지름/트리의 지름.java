import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Node>[] tree;

    static int V, max = 0, maxIndex;

    static int[] dist;

    static boolean[] visited;

    static class Node {
        int index;
        int weight;

        public Node (int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        tree = new List[V+1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            while (true) {

                int b = Integer.parseInt(st.nextToken());

                if (b == -1) break;

                int c = Integer.parseInt(st.nextToken());

                tree[a].add(new Node(b, c));
                tree[b].add(new Node(a, c));
            }
        }

        dist = new int[V+1];

        bfs(1);
        bfs(maxIndex);

        System.out.println(max);

    }

    private static void bfs(int i) {

        Queue<Node> q = new LinkedList<>();
        visited = new boolean[V+1];

        q.offer(new Node(i, 0));
        visited[i] = true;

        while (!q.isEmpty()) {

            Node node = q.poll();

            if (node.weight > max) {
                max = node.weight;
                maxIndex = node.index;
            }

            for (Node nxt : tree[node.index]) {

                if (visited[nxt.index]) continue;

                q.offer(new Node(nxt.index, nxt.weight + node.weight));
                visited[nxt.index] = true;
            }
        }
    }
}