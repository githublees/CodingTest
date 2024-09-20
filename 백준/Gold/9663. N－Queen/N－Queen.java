import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, answer = 0;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        
        nQueen(0);

        System.out.println(answer);
    }

    private static void nQueen(int depth) {

        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[depth] = i;

            if (isCheckQueen(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    private static boolean isCheckQueen(int col) {

        for (int i = 0; i < col; i++) {
            /*
             * 같은 행에 존재할 경우
             * (해당 열의 행과 i열의 행이 일치할 경우다.)
             */
            if (map[col] == map[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우 대각선에 놓여있는 경우다.)
             */
            else if (Math.abs(col-i) == Math.abs(map[col] - map[i])) {
                return false;
            }
        }

        return true;
    }
}