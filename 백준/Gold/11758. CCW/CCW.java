import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        P = new int[3][2];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            P[i][0] = Integer.parseInt(st.nextToken());
            P[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = ccw(P[0][0], P[0][1], P[1][0], P[1][1], P[2][0], P[2][1]);

        if (result == 0) {
            System.out.println(0);
        }
        else if (result > 0) {
            System.out.println(1);
        }
        else {
            System.out.println(-1);
        }
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return ((x2 - x1) * (y3 - y1)) - ((x3 - x1) * (y2 - y1));
    }
}