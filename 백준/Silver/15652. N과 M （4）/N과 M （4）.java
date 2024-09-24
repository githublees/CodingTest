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

        sequence(new boolean[N+1], new int[N], 1, 0);
    }

    private static void sequence(boolean[] visited, int[] arr, int start, int r) {

        if (r == M) {

            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = start; i <= N; i++) {
            
            arr[r] = i;
            sequence(visited, arr,  i, r+1);

        }
    }
}