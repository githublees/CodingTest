import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        permutation(new int[M], new boolean[N+1], 0);
    }

    private static void permutation(int[] arr, boolean[] visited, int r) {

        if (r == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (visited[i]) {
                continue;
            }

            arr[r] = i;
            visited[i] = true;
            permutation(arr, visited, r + 1);
            visited[i] = false;
        }
    }
}