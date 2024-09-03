import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        findZero(N);
    }

    private static void findZero(int N) {
        
        int answer = 0;

        while (N >= 5) {
            answer += N / 5;
            N /= 5;
        }
        System.out.println(answer);
    }
}