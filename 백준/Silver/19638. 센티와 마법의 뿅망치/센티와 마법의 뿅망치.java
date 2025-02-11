import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, H, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int giant = Integer.parseInt(br.readLine());
            pq.offer(giant);
        }

        int count = 0;

        while (T --> 0) {
            if (pq.peek() != 1 && pq.peek() >= H) {
                pq.offer(pq.poll() / 2);
                count++;
            }

            if (pq.peek() < H) {
                System.out.println("YES");
                System.out.println(count);
                return;
            }
        }

        System.out.println("NO");
        System.out.println(pq.poll());
    }
}