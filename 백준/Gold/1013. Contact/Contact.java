import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String pattern = "(100+1+|01)+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            String spread = br.readLine();

            if (spread.matches(pattern)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}