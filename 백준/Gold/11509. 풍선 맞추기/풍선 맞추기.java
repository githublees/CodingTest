import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] balloon = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] balloon = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int H = Integer.parseInt(st.nextToken());

            if (balloon[H] > 0) {
                // 이전에 해당 H 높이보다 한칸 위에 화살을 쐈다면
                // 화살은 현재 위치에 남아 있다. 때문에 화살을 쏠 필요가 없다.
                balloon[H]--;
            }
            balloon[H - 1]++;
        }

        System.out.println(Arrays.stream(balloon).sum());
    }
}