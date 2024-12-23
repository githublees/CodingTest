import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max = 0;
    static int[] sequence;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sequence = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
            max += sequence[i];
        }

        visited = new boolean[max + 2];

        dfs(0, 0);

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            visited[sum] = true;
            return;
        }

        dfs(depth + 1, sum + sequence[depth]);
        dfs(depth + 1, sum);
    }


}