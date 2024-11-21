import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] sequence;
    static int[] operator;

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, sequence[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int calc) {

        if (depth == N) {
            max = Math.max(max, calc);
            min = Math.min(min, calc);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] < 1) continue;

            operator[i]--;
            if (i == 0) {
                dfs(depth+1, calc + sequence[depth]);
            }
            else if (i == 1) {
                dfs(depth+1, calc - sequence[depth]);
            }
            else if (i == 2) {
                dfs(depth+1, calc * sequence[depth]);
            }
            else {
                dfs(depth+1, calc / sequence[depth]);
            }
            operator[i]++;
        }
    }
}