import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, Q;
    static int[][] picture;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        picture = new int[R+1][C+1];

        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= C; c++) {
                picture[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                picture[r][c] = picture[r][c] + picture[r-1][c] + picture[r][c-1] - picture[r-1][c-1];
            }
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int luminosity = picture[r2][c2] + picture[r1-1][c1-1] - picture[r2][c1-1] - picture[r1-1][c2];
            int count = (r2 - r1 + 1) * (c2 - c1 + 1);
            
            sb.append(luminosity/count).append("\n");
        }

        System.out.println(sb);
    }
}