import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chemical = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chemical.length; i++) {

            if (chemical[i] == 'C') {
                stack.add(12);
            } else if (chemical[i] == 'O') {
                stack.add(16);
            } else if (chemical[i] == 'H') {
                stack.add(1);
            } else if (Character.isDigit(chemical[i])) {
                stack.add(stack.pop() * (chemical[i] - '0'));
            } else if (chemical[i] == '(') {
                stack.add(-1);
            } else if (chemical[i] == ')') {
                int num = 0;
                while (stack.peek() != -1) {
                    num += stack.pop();
                }
                stack.pop();
                stack.add(num);
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}