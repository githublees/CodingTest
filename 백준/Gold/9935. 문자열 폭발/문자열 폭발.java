import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String str;
    static String explosion;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 전체 문자열
        str = br.readLine();
        // 폭발 문자열
        explosion = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            stack.push(str.charAt(i));

            if (stack.size() >= explosion.length()) {

                boolean isFlag = true;

                for (int j = 0; j < explosion.length(); j++) {

                    if (stack.get(stack.size() - explosion.length() + j) != explosion.charAt(j)) {
                        isFlag = false;
                        break;
                    }

                }

                if (isFlag) {
                    for (int j = 0; j < explosion.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);

    }
}