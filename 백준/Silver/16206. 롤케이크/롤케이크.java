import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer o1) -> o1 % 10).thenComparingInt(o1 -> o1));

        st = new StringTokenizer(br.readLine());
        for (int count = 0; count < N; count++) {
            int cake = Integer.parseInt(st.nextToken());

            if (cake == 10) {
                answer++;
                continue;
            }

            if (cake < 10) {
                continue;
            }

            pq.offer(cake);
        }

        while (M --> 0) {

            if (pq.isEmpty()) {
                break;
            }
            
            int cakeLength = pq.poll();

            if (cakeLength - 10 == 10) {
                answer++;
            }

            if (cakeLength - 10 > 10) {
                pq.offer(cakeLength - 10);
            }

            answer++;
        }

        System.out.println(answer);
    }
}