import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {

            int[][] player = new int[11][11];

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            dfs(player, new boolean[11], 11, 0, 0);
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int[][] player, boolean[] confirmed, int k, int position, int sum) {

        if (k == position) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {

            if (confirmed[i]) {
                continue;
            }

            if (player[i][position] == 0) {
                continue;
            }

            confirmed[i] = true;
            dfs(player, confirmed, k, position+1, sum + player[i][position]);
            confirmed[i] = false;
        }
    }
}