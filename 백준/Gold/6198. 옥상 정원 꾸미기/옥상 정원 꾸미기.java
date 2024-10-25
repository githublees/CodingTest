import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] build = new int[N];

        for (int i = 0; i < N; i++) {
            build[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        long answer = 0;
        for (int i = 0; i < N; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && build[stack.peek()] <= build[i]) {
                answer += i - stack.pop() - 1;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer += N - stack.pop() - 1;
        }

        System.out.println(answer);
    }
}