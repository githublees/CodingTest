import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static List<Integer>[] rank;

    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N+1];
        rank = new List[N+1];

        for (int i = 1; i <= N; i++) {
            rank[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rank[a].add(b);
            count[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int now = q.poll();

            sb.append(now).append(" ");

            for (int nxt : rank[now]) {

                count[nxt]--;

                if (count[nxt] == 0) {
                    q.offer(nxt);
                }

            }

        }

        System.out.println(sb);
    }
}