import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int[] dp = new int[N];

        int sum;
        sum = dp[0] = time[0];

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + time[i];
            sum += dp[i];
        }

        System.out.println(sum);
    }
}