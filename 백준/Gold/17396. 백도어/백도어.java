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
    static int[] vision;
    static List<Node>[] lists;
    static class Node implements Comparable<Node> {
        int index;
        long weight;

        public Node(int index, long weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return (int) (this.weight - n.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vision = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            vision[i] = Integer.parseInt(st.nextToken());
        }

        lists = new List[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lists[a].add(new Node(b, t));
            lists[b].add(new Node(a, t));
        }

        long result = solution();
        System.out.println(result != Long.MAX_VALUE ? result : -1);
    }

    private static long solution() {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visitied = new boolean[N];
        long[] distance = new long[N];

        Arrays.fill(distance, Long.MAX_VALUE);

        pq.offer(new Node(0, 0));
        distance[0] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if (now.index != N-1 && vision[now.index] == 1) {
                continue;
            }

            if (visitied[now.index]) {
                continue;
            }

            visitied[now.index] = true;

            for (Node nxt : lists[now.index]) {

                if (distance[nxt.index] > distance[now.index] + nxt.weight) {
                    distance[nxt.index] = distance[now.index] + nxt.weight;
                    pq.offer(new Node(nxt.index, distance[nxt.index]));
                }
            }
        }

        return distance[N-1];
    }
}