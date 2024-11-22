import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] ability;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(new boolean[N], 0, 0);
        System.out.println(min);
    }

    private static void combination(boolean[] choice, int start, int depth) {

        if (depth == N / 2) {
            int team_start = getAbility(choice, true);
            int team_link = getAbility(choice, false);

            min = Math.min(min, Math.abs(team_start - team_link));
            return;
        }

        for (int i = start; i < N; i++) {
            choice[i] = true;
            combination(choice, i+1, depth+1);
            choice[i] = false;
        }

    }

    private static int getAbility(boolean[] choice, boolean team) {

        int sum = 0;

        for (int i = 0; i < N; i++) {
            // 0, 1 : true;
            if (choice[i] == team) continue;

            for (int j = 0; j < N; j++) {

                if (i == j || choice[j] == team) continue;

                sum += ability[i][j];
            }
        }

        return sum;
    }
}