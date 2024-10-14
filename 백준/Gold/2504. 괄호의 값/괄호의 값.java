import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int sum = 1, result = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '(') {
                stack.push('(');
                sum *= 2;
            }
            else if (input.charAt(i) == '[') {
                stack.push('[');
                sum *= 3;
            }
            else if (input.charAt(i) == ')') {

                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                else if (input.charAt(i-1) == '(') {
                    result += sum;
                }
                stack.pop();
                sum /= 2;
            }
            else if (input.charAt(i) == ']') {

                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                else if (input.charAt(i-1) == '[') {
                    result += sum;
                }
                stack.pop();
                sum /= 3;
            }
        }

        System.out.println(stack.isEmpty() ? result : 0);


    }
}