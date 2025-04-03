import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        if (isAllSame()) {
            System.out.println(-1);
        }
        else if (hasPalindrome()) {
            System.out.println(str.length());
        }
        else {
            System.out.println(str.length()-1);
        }
    }

    private static boolean hasPalindrome() {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAllSame() {
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}