import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];

        for (int i = 0; i < 9; i++) {

            String[] number = br.readLine().split("");

            for (int j = 0; j < 9; j++) {

                board[i][j] = Integer.parseInt(number[j]);

            }
        }

        sudoku(0, 0);

    }

    private static void sudoku(int row, int col) {

        // 해당 행의 열이 모두 채워졌을 경우 다음 행 첫번째부터 시작
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 스도쿠 출력
        if (row == 9) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        // 만약 해당 위치의 값이 0 이라면 수를 찾는다.
        if (board[row][col] == 0) {

            for (int i = 1; i <= 9; i++) {

                // 넣을 수 있는 숫자면
                if (checkNum(row, col, i)) {
                    board[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            // 다른 경우의 수를 확인하기 위해 0으로 돌려 놓는다.
            board[row][col] = 0;
            return;
        }

        // 숫자가 존재할 경우 다음 열 검사
        sudoku(row, col+1);

    }

    private static boolean checkNum(int row, int col, int num) {

        // 해당 행과 열에 해당 숫자가 있는지 체크
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int rowLocation = (row/3) * 3; // 행의 첫 위치
        int colLocation = (col/3) * 3; // 열의 첫 위치

        // 존재하는 값의 위치에 해당하는 3*3 행렬에 있는지 체크
        for (int i = rowLocation; i < rowLocation+3; i++) {
            for (int j = colLocation; j < colLocation+3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}