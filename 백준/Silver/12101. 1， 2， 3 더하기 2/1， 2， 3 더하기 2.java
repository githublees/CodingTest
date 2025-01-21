import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, k, order = 0;
    static List<Integer> num;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder("-1");
        num = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        combination(0);

        System.out.println(sb);
    }

    private static void combination(int sum) {

        if (sum > n) {
            return;
        }

        if (sum == n) {
            order++;
            if (order == k) {
                sb.setLength(0);
                for (int i = 0; i < num.size() - 1; i++) {
                    sb.append(num.get(i)).append("+");
                }
                sb.append(num.get(num.size() - 1));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            num.add(i);
            combination(sum + i);
            num.remove(num.size() - 1);
        }
    }
}