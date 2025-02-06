import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, answer = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        solution(0L);

        System.out.println(answer);
    }

    private static void solution(long number) {

        if (number > B) {
            return;
        }
        
        if (number >= A) {
            answer++;
        }

        solution(number * 10 + 4);
        solution(number * 10 + 7);
    }
}