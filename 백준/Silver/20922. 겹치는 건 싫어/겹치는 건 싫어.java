import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] count = new int[100001];
        int start = 0, end = 0;

        while (end < N) {
            while (end < N && count[sequence[end]] + 1 <= K) {
                count[sequence[end++]]++;
            }
            int len = end - start;
            answer = Math.max(answer, len);
            
            count[sequence[start++]]--;
        }

        System.out.println(answer);
    }
}