import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] tower, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        tower = new int[N];
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            if (stack.isEmpty()) {
                stack.push(i);
                answer[i] = 0;
                continue;
            }

            while (!stack.isEmpty()) {
                if (tower[stack.peek()] >= tower[i]) {
                    answer[i] = stack.peek() + 1;
                    break;
                } else {
                    stack.pop();
                }
            }

            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}