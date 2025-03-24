import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean flag;
    static char[][] tictac;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while (!(str = br.readLine()).equals("end")) {

            int xCnt = 0;
            int oCnt = 0;
            tictac = new char[3][3];

            for (int i = 0; i < 9; i++) {

                tictac[i/3][i%3] = str.charAt(i);

                if (tictac[i/3][i%3] == 'X') {
                    xCnt++;
                } else if (tictac[i/3][i%3] == 'O') {
                    oCnt++;
                }
            }

            // X가 이긴 경우
            if(xCnt == oCnt+1) {
                // 판이 가득차고 O가 완성되지 않은 경우
                if(xCnt+oCnt == 9 && !check('O')) {
                    sb.append("valid");
                }
                // O가 완성 되지 않고, X가 완성 된 경우
                else if(!check('O') && check('X')) {
                    sb.append("valid");
                }
                // 둘 다 아닌 경우는 X도 이기지 못함
                else {
                    sb.append("invalid");
                }
            }
            // O가 이긴 경우
            else if(xCnt == oCnt) {
                // X가 완성되지 않고, O가 완성된 경우
                if(!check('X') && check('O')) {
                    sb.append("valid");
                }
                // 그게 아니라면 먼저 두는 것은 X이기 때문에 이길 수 없음
                else {
                    sb.append("invalid");
                }
            }
            // 둘 다 완성되지 않은 경우
            else {
                sb.append("invalid");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean check(char c) {

        for(int i=0; i<3; i++) {
            // 가로 한줄로 성공한 경우
            if(tictac[i][0] == c && tictac[i][1] == c && tictac[i][2] == c) {
                return true;
            }
        }

        for(int i=0; i<3; i++) {
            // 세로 한줄로 성공한 경우
            if(tictac[0][i] == c && tictac[1][i] == c && tictac[2][i] == c) {
                return true;
            }
        }

        // 대각선으로 성공한 경우, 좌상에서 우하로
        if(tictac[0][0] == c && tictac[1][1] == c && tictac[2][2] == c) {
            return true;
        }

        // 대각선으로 성공한 경우, 우상에서 좌하로
        if(tictac[0][2] == c && tictac[1][1] == c && tictac[2][0] == c) {
            return true;
        }

        // 여기까지 return이 없을 경우 끝나지 않음
        return false;
    }
}