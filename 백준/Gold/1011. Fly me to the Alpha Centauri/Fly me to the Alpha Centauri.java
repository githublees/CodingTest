import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = y - x;
            int sqrtDist = (int) Math.sqrt(dist);

            if (dist == sqrtDist * sqrtDist) {
                sb.append(2 * sqrtDist - 1).append("\n");
            }
            else if (dist <= sqrtDist * sqrtDist + sqrtDist) {
                sb.append(2 * sqrtDist).append("\n");
            }
            else {
                sb.append(2 * sqrtDist + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}