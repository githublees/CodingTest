import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] HW = br.readLine().split(" ");

        int H = Integer.parseInt(HW[0]);
        int W = Integer.parseInt(HW[1]);

        int[] map = new int[W];
        int max = 0, midx = 0;
        int answer = 0;

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(str[i]);
            if(max < map[i]) {
                max = map[i];
                midx = i;
            }
        }

        int left = map[0];
        for (int i = 0; i < midx; i++) {
            if(left < map[i]) {
                left = map[i];
                continue;
            }

            answer += left - map[i];
        }

        int right = map[W-1];
        for (int i = W-1; i > midx; i--) {
            if(right < map[i]) {
                right = map[i];
                continue;
            }

            answer += right - map[i];
        }

        System.out.println(answer);
    }
}