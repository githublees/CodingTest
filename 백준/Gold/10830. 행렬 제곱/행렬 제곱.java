import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[][] matrix = new long[N][N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {

                matrix[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        long[][] result = pow(matrix, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static long[][] pow(long[][] matrix, long exp) {

        if (exp == 1 || exp == 0) {
            return origin(matrix);
        }

        long[][] ret = pow(matrix, exp / 2);

        ret = multifly(ret, ret);

        if (exp % 2 == 1L) {
            ret = multifly(ret, matrix);
        }

        return ret;

    }

    private static long[][] multifly(long[][] o1, long[][] o2) {

        long[][] result = new long[N][N];

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result[i][j] += o1[i][k] * o2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }

    private static long[][] origin(long[][] o1) {

        long[][] result = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = o1[i][j] % 1000;
            }
        }

        return result;
    }
}