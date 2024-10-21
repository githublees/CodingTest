import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N > 20) {
            System.out.println(new BigDecimal("2").pow(N).subtract(BigDecimal.ONE));
            return;
        }

        System.out.println((long)(Math.pow(2, N) - 1));
        hanoi(N, 1, 3, 2);
    }

    private static void hanoi(int N, int start, int end, int via) {
        if (N == 1) {
            move(start, end);
            return;
        }

        hanoi(N-1, start, via, end);
        move(start, end);
        hanoi(N-1, via, end, start);
    }

    private static void move(int start, int end) {
        System.out.println(start + " " + end);
    }
}