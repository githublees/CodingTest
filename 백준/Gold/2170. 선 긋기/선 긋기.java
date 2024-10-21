import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        line = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        int min_x = line[0][0], max_y = line[0][1];
        int answer = max_y - min_x;

        for (int i = 1; i < N; i++) {

            if (line[i][0] > max_y) {
                min_x = line[i][0];
                max_y = line[i][1];
                answer += max_y - min_x;
            }
            else {
                if (line[i][1] > max_y) {
                    answer += line[i][1] - max_y;
                    max_y = line[i][1];
                }
            }
        }
        System.out.println(answer);
    }
}