import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] tree = new int[N];

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tree[i]);
        }

        long res = Integer.MIN_VALUE;

        for (int i = 1; i <= max; i++) {

            long sum = 0;

            for (int j = 0; j < N; j++) {

                int cut = 0;

                if (tree[j] >= i) {
                    
                    if (tree[j] % i == 0) {
                        cut = tree[j] / i - 1;
                    }
                    else {
                        cut = tree[j] / i;
                    }

                    int cost = W * i * (tree[j] / i) - cut * C;

                    if (cost > 0) {
                        sum += cost;
                    }
                }
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
}