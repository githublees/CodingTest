import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int[] arr;
    static StringBuilder[] sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder[K];
        for (int i = 0; i < K; i++) {
            sb[i] = new StringBuilder();
        }

        solve(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++) {
            System.out.println(sb[i]);
        }
    }

    private static void solve(int s, int e, int depth) {

        if (depth == K) {
            return;
        }

        int m = (s + e) / 2;
        sb[depth].append(arr[m] + " ");

        solve(s, m - 1, depth + 1);
        solve(m + 1, e, depth + 1);
    }
}