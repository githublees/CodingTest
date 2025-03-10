import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, Q, result;
    static List<Pair>[] video;
    static boolean[] visited;

    static class Pair {
        int index;
        int weight;

        public Pair(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        video = new List[N+1];

        for (int i = 1; i <= N; i++) {
            video[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            video[p].add(new Pair(q, r));
            video[q].add(new Pair(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            result = 0;
            visited = new boolean[N+1];
            visited[v] = true;
            recommend(Integer.MAX_VALUE, k, v);

            System.out.println(result);
        }
    }

    private static void recommend(int usado, int k, int v) {

        if (usado != Integer.MAX_VALUE && k <= usado) {
            result++;
        }

        for (Pair pair : video[v]) {

            if (visited[pair.index]) {
                continue;
            }

            visited[pair.index] = true;
            
            recommend(Math.min(usado, pair.weight), k, pair.index);
        }
    }
}