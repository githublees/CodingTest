import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;

        while (true) {

            str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            sb.append(solve(str)).append("\n");
        }

        System.out.println(sb);
    }

    private static String solve(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(' || ch == '[') {

                stack.push(ch);

            } else if (ch == ')') {

                // 스택이 비어 있거나 pop 할 원소가 소괄호랑 매칭이 안되는 경우
                if (stack.empty() || stack.peek() != '(') {

                    return "no";

                } else {

                    stack.pop();

                }

            } else if (ch == ']') {

                // 스택이 비어 있거나 pop 할 원소가 대괄호랑 매칭이 안되는 경우
                if (stack.empty() || stack.peek() != '[') {

                    return "no";

                } else {

                    stack.pop();

                }
            }
        }

        if (stack.empty()) {

            return "yes";

        } else {

            return "no";

        }
    }
}