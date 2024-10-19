import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(new StringBuilder(T));

        System.out.println(0);
    }

    private static void dfs(StringBuilder sb) {

        if (sb.length() == S.length()) {
            if (sb.toString().equals(S)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        char lastWord = sb.charAt(sb.length() - 1);

        sb.deleteCharAt(sb.length() - 1);

        if (lastWord == 'B') {
            sb.reverse();
        }

        dfs(new StringBuilder(sb));
    }
}