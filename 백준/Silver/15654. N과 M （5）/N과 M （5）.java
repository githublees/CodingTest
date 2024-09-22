import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[] num;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        sequence(new boolean[N], new int[M], 0, 0);

        System.out.println(sb);

    }

    private static void sequence(boolean[] visited, int[] arr, int start, int r) {

        if (r == M) {

            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {

            if (visited[i]) continue;

            arr[r] = num[i];
            visited[i] = true;
            sequence(visited, arr, i+1, r+1);
            visited[i] = false;
        }
    }
}