import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sequence = new int[n+1];

        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        isFindSequenceStack(n);

    }

    private static void isFindSequenceStack(int n) {

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int index = 1;
        for (int i = 1; i <= n; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                sb.append("+").append("\n");
                continue;
            }

            while (!stack.isEmpty()) {
                if (stack.peek() == sequence[index]) {
                    stack.pop();
                    sb.append("-").append("\n");
                    index++;
                } else {
                    break;
                }
            }

            stack.push(i);
            sb.append("+").append("\n");
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == sequence[index]) {
                stack.pop();
                sb.append("-").append("\n");
                index++;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}