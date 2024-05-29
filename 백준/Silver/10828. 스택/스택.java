import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        while (N --> 0) {

            String[] order = br.readLine().split(" ");
            int result = 0;

            if (order[0].equals("push")) {
                stack.push(Integer.parseInt(order[1]));
                continue;

            } else if (order[0].equals("pop")) {
                result = stack.empty() ? -1 : stack.pop();

            } else if (order[0].equals("size")) {
                result = stack.size();

            } else if (order[0].equals("empty")) {
                result = stack.empty() ? 1 : 0;

            } else if (order[0].equals("top")) {
                result = stack.empty() ? -1 : stack.peek();
            }

            System.out.println(result);
        }
    }
}