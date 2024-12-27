import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        for (int i = L; i <= R; i++) {

            int number = i;
            int count = 0;

            while (number > 0) {
                
                if (count >= min) break;

                if (number % 10 == 8) {
                    count++;
                }
                number /= 10;
            }

            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}