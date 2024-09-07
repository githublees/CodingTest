import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while (T --> 0) {

            String[] order = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] matrix = input.substring(1, input.length()-1).split(",");
            Deque<Integer> numbers = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                numbers.add(Integer.parseInt(matrix[i]));
            }

            AC ac = new AC(order, numbers);
            result.append(ac.start()).append("\n");
        }

        System.out.println(result);
    }

    private static class AC {
        private String[] order;
        private Deque<Integer> numbers;

        private boolean isFlag = false;

        public AC(String[] order, Deque<Integer> numbers) {
            this.order = order;
            this.numbers = numbers;
        }

        public String start() {
            for (int i = 0; i < order.length; i++) {
                if (this.order[i].equals("R")) {

                    this.reverse();

                }
                else if (this.order[i].equals("D")) {

                    if (this.numbers.isEmpty()) {
                        return "error";
                    }

                    this.delete();
                }
            }

            return this.toString();
        }

        public void reverse() {
            isFlag = !isFlag;
        }

        public void delete() {
            if (!isFlag) {
                numbers.pollFirst();
            } else {
                numbers.pollLast();
            }
        }

        @Override
        public String toString() {

            if (numbers.isEmpty()) return "[]";

            StringBuilder sb = new StringBuilder();

            sb.append("[");
            while (!numbers.isEmpty()) {
                if (isFlag) {
                    sb.append(numbers.pollLast()).append(",");
                } else {
                    sb.append(numbers.pollFirst()).append(",");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");

            return sb.toString();
        }
    }
}