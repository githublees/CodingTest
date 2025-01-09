import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] balls = new char[N];
        int answer = Integer.MAX_VALUE;
        int red = 0, blue = 0;

        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'R') {
                red++;
            }
            else {
                blue++;
            }
            balls[i] = str.charAt(i);
        }

        int ballCnt = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'R') {
                ballCnt++;
            } else {
                break;
            }
        }
        answer = Math.min(answer, red - ballCnt);

        ballCnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if (balls[i] == 'R') {
                ballCnt++;
            } else {
                break;
            }
        }
        answer = Math.min(answer, red - ballCnt);

        ballCnt = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] == 'B') {
                ballCnt++;
            } else {
                break;
            }
        }
        answer = Math.min(answer, blue - ballCnt);

        ballCnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if (balls[i] == 'B') {
                ballCnt++;
            } else {
                break;
            }
        }
        answer = Math.min(answer, blue - ballCnt);

        System.out.println(answer);
    }
}