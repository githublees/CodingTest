import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int N, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 0; i < 7; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            if (stacks[line].isEmpty() || stacks[line].peek() < fret) {
                stacks[line].push(fret);
                answer++;
                continue;
            }

            while (!stacks[line].isEmpty() && stacks[line].peek() > fret) {
                stacks[line].pop();
                answer++;
            }

            if (stacks[line].isEmpty() || stacks[line].peek() < fret) {
                stacks[line].push(fret);
                answer++;
            }
        }

        System.out.println(answer);
    }
}