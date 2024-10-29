import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, R, Q;
    static List<Integer>[] tree;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        parents = new int[N+1];

        Arrays.fill(parents, 1);

        tree = new List[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            tree[U].add(V);
            tree[V].add(U);
        }

        findParents(R, -1);
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(parents[query]);
        }

    }

    private static int findParents(int node, int parent) {

        for (int nxt : tree[node]) {

            if (nxt == parent) continue;

            parents[node] += findParents(nxt, node);
        }

        return parents[node];

    }
}