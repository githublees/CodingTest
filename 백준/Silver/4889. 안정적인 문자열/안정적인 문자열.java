import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        String str;
        while ((str = br.readLine()).charAt(0) != '-') {

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }

            int count = 0, left = 0;
            while (!stack.isEmpty()) {

                char parentheses = stack.pop();

                if (parentheses == '}') {
                    left++;
                }
                else {
                    left--;
                }

                if (left < 0) {
                    left += 2;
                    count++;
                }
            }

            if (left != 0) {
                count += left / 2;
            }

            sb.append(index + ". " + count).append("\n");

            index++;
        }

        System.out.println(sb);
    }
}