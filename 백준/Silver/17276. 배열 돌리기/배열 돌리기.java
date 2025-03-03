import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 회전
            if (d < 0) {
                d += 360;
            }

            for (int i = 0; i < d/45; i++) {
                rotation(matrix, n);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(matrix[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
    }

    private static void rotation(int[][] matrix, int n) {

        int[] middle = new int[n];

        for (int i = 0; i < n; i++) {
            middle[i] = matrix[i][n/2];
        }

        for (int i = 0; i < n; i++) {
            matrix[i][n/2] = matrix[i][i];
            matrix[i][i] = matrix[n/2][i];
            matrix[n/2][i] = matrix[n-i-1][i];
            matrix[n-i-1][i] = middle[n-1-i];
        }
    }
}