import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {
                System.out.println(i+1);
                return;
            } else {
                union(x, y);
            }
        }

        System.out.println(0);

    }

    private static void union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[a] = b;
    }

    private static int find (int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}