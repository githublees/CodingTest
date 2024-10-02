import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[][] polygon = new long[N+1][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            polygon[i][0] = x;
            polygon[i][1] = y;

        }
        
        polygon[N][0] = polygon[0][0];
        polygon[N][1] = polygon[0][1];

        long xy = 0L, yx = 0L;

        for (int i = 0; i < N; i++) {

            xy += polygon[i][0] * polygon[i+1][1];
            yx += polygon[i][1] * polygon[i+1][0];
        }

        System.out.println(String.format("%.1f", Math.abs(xy - yx) / 2D));
    }
}