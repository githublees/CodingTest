import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bars = br.readLine();

        int answer = 0;
        int left = 0;

        for (int i = 0; i < bars.length(); i++) {

            if (bars.charAt(i) == '(') {
                left++;
            } else {
                left--;

                if (bars.charAt(i - 1) == '(') {
                    answer += left;
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}