import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static List<Integer>[] order;
    static int[] count;

    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N+1];
        order = new List[N+1];
        answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            order[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n - 1; j++) {

                int end = Integer.parseInt(st.nextToken());
                count[end]++;
                order[start].add(end);
                start = end;

            }
        }

        kruskal();
        print();
    }

    private static void print() {

        StringBuilder sb = new StringBuilder();

        if (answer.size() != N) {
            sb.append(0);
        }
        else {
            for (int x : answer) {
                sb.append(x).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static void kruskal() {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {

            int now = q.poll();

            answer.add(now);

            for (int nxt : order[now]) {

                count[nxt]--;

                if (count[nxt] == 0) {
                    q.offer(nxt);
                }

            }
        }
    }
}