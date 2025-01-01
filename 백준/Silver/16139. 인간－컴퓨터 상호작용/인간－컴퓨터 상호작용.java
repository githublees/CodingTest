import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String S;
    static int q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        S = br.readLine();
        q = Integer.parseInt(br.readLine());
        int[][] sum = new int[26][S.length() + 1];

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= S.length(); j++) {
                sum[i][j] = S.charAt(j-1) - 'a' == i ? sum[i][j-1] + 1 : sum[i][j-1];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int alphabet = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(sum[alphabet][r+1] - sum[alphabet][l]).append("\n");
        }

        System.out.println(sb);
    }
}