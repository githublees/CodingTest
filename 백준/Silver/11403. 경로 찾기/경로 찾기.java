import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int m = 0; m < N; m++) {

            for (int s = 0; s < N; s++) {

                for (int e = 0; e < N; e++) {

                    if (matrix[s][m] == 1 && matrix[m][e] == 1) {
                        matrix[s][e] = 1;
                    }


                }

            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                sb.append(matrix[i][j]).append(" ");

            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}