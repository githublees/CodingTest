import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            int count = 0;

            for (int j = 0; j < N; j++) {

                if (i == j) continue;
                
                if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) {

                    count++;

                }
            }

            sb.append(count+1).append(" ");
        }

        System.out.println(sb);
    }


}