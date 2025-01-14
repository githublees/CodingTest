import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int T;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {

            int n = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();

            while (n > 0) {

                for (int i = 46; i >= 0; i--) {

                    if (n >= dp[i]) {
                        list.add(dp[i]);
                        n -= dp[i];
                        break;
                    }
                }
            }

            Collections.sort(list);
            for (int num : list) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {
        dp = new int[47];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < 47; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
}