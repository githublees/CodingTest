import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E, answer = 0;

    static int[] parent;

    static List<Node> graph;

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo (Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        parent = new int[V+1];
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, C));
        }

        Collections.sort(graph);

        kruskal();

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[a] = b;
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void kruskal() {

        for (Node node : graph) {

            if (find(node.from) != find(node.to)) {

                answer += node.weight;
                union(node.from, node.to);

            }

        }
    }
}