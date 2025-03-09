import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        boolean flag = false;
        int prev = 1, now = 2;

        while (now < 100_000) {

            int result = now * now - prev * prev;

            if (result == G) {
                System.out.println(now);
                flag = true;
            }

            if (result < G) {
                now++;
            }
            else {
                prev++;
            }
        }

        if (!flag) {
            System.out.println("-1");
        }
    }
}