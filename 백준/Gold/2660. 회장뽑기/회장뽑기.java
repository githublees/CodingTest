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

    static int N;
    static List<Integer>[] members;

    static class Pos {
        int index;
        int depth;

        Pos (int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        members = new List[N+1];
        for (int i = 1; i <= N; i++) {
            members[i] = new ArrayList<>();
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 || b == -1) break;

            members[a].add(b);
            members[b].add(a);
        }

        int min = N;
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int score = bfs(i);

            if (min == score) {
                answer.add(i);
            }
            else if (min > score) {
                min = score;
                answer = new ArrayList<>();
                answer.add(i);
            }
        }

        Collections.sort(answer);

        System.out.println(min + " " + answer.size());
        for (int member : answer) {
            System.out.print(member + " ");
        }
    }

    private static int bfs(int start) {
        Queue<Pos> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.offer(new Pos(start, 0));
        visited[start] = true;

        int score = 0;
        while (!q.isEmpty()) {

            Pos now = q.poll();

            score = Math.max(score, now.depth);

            for (int nxt : members[now.index]) {
                if (visited[nxt]) continue;
                q.offer(new Pos(nxt, now.depth+1));
                visited[nxt] = true;
            }

        }
        return score;

    }
}