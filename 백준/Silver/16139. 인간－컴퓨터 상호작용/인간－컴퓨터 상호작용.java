import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static char[] S;
    static int q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Character, int[]> map = new HashMap<>();

        S = br.readLine().toCharArray();
        for (char i = 'a'; i <= 'z'; i++) {

            int[] sum = new int[S.length + 1];

            for (int j = 1; j <= S.length; j++) {

                if (S[j-1] == i) {
                    sum[j] = sum[j-1] + 1;
                } else {
                    sum[j] = sum[j-1];
                }
            }

            map.put(i, sum);
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String alphabet = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] sum = map.get(alphabet.charAt(0));
            System.out.println(sum[r+1] - sum[l]);
        }
    }
}