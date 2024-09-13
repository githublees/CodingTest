import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] squares;

    static class Pos {

        int pos;
        int cnt;

        public Pos (int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        squares = new int[101];

        for (int i = 1; i <= 100; i++) {
            squares[i] = i;
        }

        while (N+M --> 0) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            squares[start] = end;
        }

        System.out.println(snakeAndLadderGame());
    }

    private static int snakeAndLadderGame() {

        Queue<Pos> q = new LinkedList<>();
        boolean[] visited = new boolean[101];

        q.offer(new Pos(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (p.pos == 100) {
                return p.cnt;
            }

            for (int i = 6; i >= 1; i--) {

                int np = p.pos + i;

                if (np < 0 || np > 100 || visited[squares[np]]) continue;

                q.offer(new Pos(squares[np], p.cnt+1));
                visited[squares[np]] = true;

            }
        }

        return 1;
    }
}