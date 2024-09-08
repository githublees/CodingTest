import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ioi = new StringBuilder();
        StringBuilder window = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] S = br.readLine().split("");


        int length = N*2+1;
        int answer = 0;

        for (int i = 1; i <= length; i++) {
            if (i % 2 == 0) {
                ioi.append("O");
            } else {
                ioi.append("I");
            }
        }

        for (int i = 0; i < length; i++) {
            window.append(S[i]);
        }

        for (int i = length; i < M; i++) {

            if (ioi.compareTo((window)) == 0) {
                answer++;
            }

            window.deleteCharAt(0);
            window.append(S[i]);
        }

        if (ioi.compareTo((window)) == 0) {
            answer++;
        }

        System.out.println(answer);
    }
}