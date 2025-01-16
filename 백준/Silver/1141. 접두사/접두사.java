import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        word = new String[N];

        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }

        Arrays.sort(word);

        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (word[i].startsWith(word[i-1])) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}