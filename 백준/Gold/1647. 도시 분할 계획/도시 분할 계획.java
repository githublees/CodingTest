import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = 0;
    static int N, M;

    static List<Node> house;

    static int[] parents;

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();

        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            house.add(new Node(A, B, C));
        }

        Collections.sort(house);

        kruskal();

        System.out.println(answer);
    }

    public static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parents[a] = b;
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static void kruskal() {

        int max_value = 0;

        for (Node node : house) {

            if (find(node.from) != find(node.to)) {

                answer += node.weight;
                union(node.from, node.to);

                max_value = Math.max(max_value, node.weight);
            }
        }

        answer -= max_value;

    }


}