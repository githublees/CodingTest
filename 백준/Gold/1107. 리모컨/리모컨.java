import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, pushCnt;

    static boolean[] broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 찾는 버튼
        N = Integer.parseInt(br.readLine());
        // 망가진 버튼 수
        M = Integer.parseInt(br.readLine());
        // 망가진 버튼
        broken = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int button = Integer.parseInt(st.nextToken());
                broken[button] = true;
            }
        }

        // 100일 경우 누를 필요가 없기에 0을 출력
        if (N == 100) {
            System.out.println(0);
            return;
        }

        // 초기 눌러야 하는 최소 횟수
        pushCnt = Math.abs(N - 100);

        // 탐색
        solution();

        System.out.println(pushCnt);
    }

    private static void solution() {

        for (int i = 0; i <= 999999; i++) {

            String number = String.valueOf(i);
            boolean isFlag = false;

            for (int j = 0; j < number.length(); j++) {

                // 고장난 버튼이면
                if (broken[number.charAt(j) - '0']) {
                    isFlag = true;
                    break;
                }
            }

            // 고장나지 않았다면
            if (!isFlag) {
                pushCnt = Math.min(pushCnt, number.length() + Math.abs(N - i));
            }
        }
    }
}