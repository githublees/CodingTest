import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int min = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int position = Integer.parseInt(br.readLine());
                int minTime = Math.min(position, length - position);
                int maxTime = Math.max(position, length - position);

                min = Math.max(min, minTime);
                max = Math.max(max, maxTime);
            }

            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}