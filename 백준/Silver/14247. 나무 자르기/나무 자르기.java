import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long sum = 0;
        int n = Integer.parseInt(br.readLine());
        long[][] tree = new long[n][2];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tree[j][i] = Long.parseLong(st.nextToken());
            }
        }

        Arrays.sort(tree, Comparator.comparingLong(o -> o[1]));

        for (int day = 0; day < n; day++) {
            sum += tree[day][0] + tree[day][1] * day;
        }

        System.out.println(sum);
    }
}