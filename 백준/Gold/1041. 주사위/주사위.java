import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dice = new long[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long[] min = new long[3];
        min[0] = Math.min(dice[0], dice[5]);
        min[1] = Math.min(dice[1], dice[4]);
        min[2] = Math.min(dice[2], dice[3]);
        
        Arrays.sort(min);
        
        
        long[] answer = new long[3];
        answer[0] = 4L;
        answer[1] = 8L * (N-2) + 4L;
        answer[2] = 5L * (N-2) * (N-2) + 4L * (N-2);
        
        if (N == 1) {
            Arrays.sort(dice);
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        }
        else {
            System.out.println(answer[0] * (min[0] + min[1] + min[2])
                                        + answer[1] * (min[0] + min[1])
                                        + answer[2] * min[0]);
        }

    }
}