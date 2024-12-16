import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 10000000;
    static int N, D;
    static List<Node>[] road;

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        road = new List[D + 1];

        for (int i = 0; i <= D; i++) {
            road[i] = new ArrayList<>();
            if (i != D) {
                road[i].add(new Node(i + 1, 1));
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end <= D) {
                road[start].add(new Node(end, distance));
            }
        }

        System.out.println(dijkstart());


    }

    private static int dijkstart() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[D+1];

        Arrays.fill(distance, INF);
        pq.offer(new Node(0, 0));
        distance[0] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (distance[now.index] < now.weight) continue;

            for (Node nxt : road[now.index]) {

                if (distance[nxt.index] > distance[now.index] + nxt.weight) {
                    distance[nxt.index] = distance[now.index] + nxt.weight;
                    pq.offer(new Node(nxt.index, distance[nxt.index]));
                }
            }
        }

        return distance[D];
    }
}