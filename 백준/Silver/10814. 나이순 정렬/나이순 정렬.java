import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] user = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // age
            user[i][0] = st.nextToken();
            // name
            user[i][1] = st.nextToken();
        }

        Arrays.sort(user, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
        for (int i = 0; i < N; i++) {
            System.out.println(user[i][0] + " " + user[i][1]);
        }
    }
}