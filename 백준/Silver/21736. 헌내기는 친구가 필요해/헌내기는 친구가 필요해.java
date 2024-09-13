import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Pos {

        int x;
        int y;

        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];

        int start_x = 0, start_y = 0;

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);

                if (campus[i][j] == 'I') {
                    start_x = i;
                    start_y = j;
                }
            }

        }

        int answer = findFriends(campus, start_x, start_y);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static int findFriends(char[][] campus, int start_x, int start_y) {

        int answer = 0;
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.offer(new Pos(start_x, start_y));
        visited[start_x][start_y] = true;

        while (!q.isEmpty()) {

            Pos p = q.poll();

            if (campus[p.x][p.y] == 'P') {
                answer++;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || campus[nx][ny] == 'X') continue;

                q.offer(new Pos(nx, ny));
                visited[nx][ny] = true;
            }

        }

        return answer;
    }
}