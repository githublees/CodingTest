import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String minkyeom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        minkyeom = br.readLine();

        System.out.println(getMaxNumber());
        System.out.println(getMinNumber());
    }

    private static String getMaxNumber() {

        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        for (int i = 0; i < minkyeom.length(); i++) {

            char ch = minkyeom.charAt(i);

            if (cnt == 0 && ch == 'K') {
                sb.append(5);
            }
            else if (cnt > 0 && ch == 'K') {
                sb.append(5).append("0".repeat(cnt));
                cnt = 0;
            }
            else if (ch == 'M') {
                cnt++;
            }
        }

        if (cnt != 0) {
            sb.append("1".repeat(cnt));
        }

        return sb.toString();
    }

    private static String getMinNumber() {

        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        for (int i = 0; i < minkyeom.length(); i++) {

            char ch = minkyeom.charAt(i);

            if (cnt == 0 && ch == 'K') {
                sb.append(5);
            }
            else if (cnt > 0 && ch == 'K') {
                sb.append(1).append("0".repeat(cnt-1)).append(5);
                cnt = 0;
            }
            else if (ch == 'M') {
                cnt++;
            }
        }

        if (cnt != 0) {
            sb.append(1).append("0".repeat(cnt-1));
        }

        return sb.toString();
    }
}