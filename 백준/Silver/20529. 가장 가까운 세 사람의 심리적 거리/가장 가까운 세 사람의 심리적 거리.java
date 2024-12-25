import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int N = Integer.parseInt(br.readLine());
            String[] personality = new String[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                personality[i] = st.nextToken();
            }


            if (N > 32) {
                System.out.println(0);
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int A = 0; A < N - 2; A++) {
                for (int B = A+1; B < N - 1; B++) {
                    for (int C = B+1; C < N; C++) {
                        min = Math.min(min, solution(personality[A], personality[B]) + solution(personality[B], personality[C]) + solution(personality[A], personality[C]));
                    }
                }
            }

            System.out.println(min);
        }
    }

    private static int solution(String o1, String o2) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                result += 1;
            }
        }
        return result;
    }
}