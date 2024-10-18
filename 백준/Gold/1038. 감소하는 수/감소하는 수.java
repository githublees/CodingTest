import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Long> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();

        if (N >= 0 && N <= 9) {
            System.out.println(N);
            return;
        }
        else if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i);
        }

        Collections.sort(numbers);
        System.out.println(numbers.get(N));

    }

    private static void dfs(long n) {

        numbers.add(n);

        if (n % 10 == 0) return;

        for (long i = 0; i < n % 10; i++) {
            dfs( n * 10 + i);
        }
    }
}