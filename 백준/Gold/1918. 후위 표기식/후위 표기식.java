import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] exp = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length; i++) {

            int p = priority(exp[i]);

            switch (exp[i]) {
                case "+" :
                case "-" :
                case "*" :
                case "/" :
                    while (!stack.isEmpty() && priority(stack.peek()) >= p) {
                        sb.append(stack.pop());
                    }

                    stack.push(exp[i]);
                    break;

                case ")" :
                    while (!stack.isEmpty() && stack.peek() != "(") {
                        sb.append(stack.pop());
                    }

                    stack.pop();
                    break;

                case "(" :
                    stack.push("(");
                    break;

                default:
                    sb.append(exp[i]);
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static int priority(String exp) {
        switch (exp) {
            case "*" :
            case "/" : return 2;
            case "-" :
            case "+" : return 1;
            default  : return 0;
        }
    }
}