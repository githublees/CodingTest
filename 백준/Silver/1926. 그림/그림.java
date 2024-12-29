import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int total = 0, max = 0, count = 0;
    static int[][] paper;
    static boolean[][] done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        done = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (done[i][j] || paper[i][j] == 0) {
                    continue;
                }
                count = 0;
                dfs(i, j);
                total++;
            }
        }

        System.out.println(total);
        System.out.println(max);
    }

    private static void dfs(int col, int row) {

        if (col < 0 || row < 0 || col >= n || row >= m) {
            return;
        }

        if (done[col][row] || paper[col][row] == 0) {
            return;
        }

        count++;
        done[col][row] = true;
        max = Math.max(max, count);

        dfs(col + 1, row);
        dfs(col , row + 1);
        dfs(col - 1, row);
        dfs(col, row - 1);
    }
}