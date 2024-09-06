import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        while (K --> 0) {

            int number = Integer.parseInt(br.readLine());

            if (!stack.empty() && number == 0) {

                stack.pop();

            } else {

                stack.push(number);

            }
        }

        while (!stack.empty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}