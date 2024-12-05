import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] matrix;
    static int[][] answer;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                answer[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        solution();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] != answer[i][j]) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(result);
    }

    private static void solution() {
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (matrix[i][j] == answer[i][j]) {
                    continue;
                }
                flip(i, j);
                result++;
            }
        }
    }

    private static void flip(int i, int j) {
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                matrix[k][l] = (matrix[k][l] == 0 ? 1 : 0);
            }
        }
    }
}