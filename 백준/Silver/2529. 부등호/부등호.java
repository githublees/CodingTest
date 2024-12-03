import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static String[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken();
        }

        dfs("", 0);
        Collections.sort(answer);

        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
    }

    private static void dfs(String num, int r) {

        if (r == k+1) {
            answer.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (r == 0 || check(Character.getNumericValue(num.charAt(r-1)), i, sign[r-1])) {
                visited[i] = true;
                dfs(num + i, r+1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, String c) {
        if (c.equals("<")) {
            return a <= b;
        }
        else if (c.equals(">")) {
            return a >= b;
        }
        return true;
    }
}