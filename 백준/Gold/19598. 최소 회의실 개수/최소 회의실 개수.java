import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Metting implements Comparable<Metting> {

        int start, end;

        public Metting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Metting o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Metting> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Metting(start, end));
        }

        Collections.sort(list);

        int max = 0;

        for (Metting metting : list) {

            while (!pq.isEmpty() && pq.peek() <= metting.start) {
                pq.poll();
            }

            pq.offer(metting.end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}