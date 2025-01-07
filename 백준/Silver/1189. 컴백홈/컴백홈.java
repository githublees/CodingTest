import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int distance) {
        
        if (x == 0 && y == C-1 && distance == K) {
            answer++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || map[nx][ny] == 'T') {
                continue;
            }
            
            visited[nx][ny] = true;
            dfs(nx, ny, distance+1);
            visited[nx][ny] = false;
        }
    }
}