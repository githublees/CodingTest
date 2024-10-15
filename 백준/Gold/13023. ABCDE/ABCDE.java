import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new List[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0, new boolean[N]);
        }

        System.out.println(0);
    }

    private static void dfs(int i, int c, boolean[] visited) {

        if (visited[i]) return;

        visited[i] = true;

        if (c == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for (int nxt : friends[i]) {
            dfs(nxt, c+1, visited);
        }

        visited[i] = false;
    }
}