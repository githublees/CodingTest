import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static class Pos {
        int index;
        int distance;

        public Pos(int index, int distance) {
            this.index = index;
            this.distance = distance;
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

            graph[a].add(b);
            graph[b].add(a);
        }

        solution();
    }

    private static void solution() {
        Queue<Pos> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        List<Integer> answer = new ArrayList<>();
        int max = 0;

        q.offer(new Pos(1, 0));

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (visited[p.index]) continue;

            visited[p.index] = true;

            if (max < p.distance) {
                answer.clear();
                answer.add(p.index);
                max = p.distance;
            } else if (max == p.distance) {
                answer.add(p.index);
            }

            for (int nxt : graph[p.index]) {
                q.offer(new Pos(nxt, p.distance + 1));
            }
        }

        Collections.sort(answer);
        System.out.println(answer.get(0) + " " + max + " " + answer.size());
    }
}