import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Pool implements Comparable<Pool> {
        int start;
        int end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool p) {
            if (this.start == p.start) {
                return p.end - this.end;
            }
            return this.start - p.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<Pool> pq = new PriorityQueue<>();

        for (int pool = 0; pool < N; pool++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Pool(start, end));
        }

        int board = 0;
        int now = 0;

        while (!pq.isEmpty()) {

            Pool pool = pq.poll();

            if (pool.end < now) {
                continue;
            }
            
            if (pool.start > now) {
                now = pool.start;
            }

            // 웅덩이를 덮고 남는 판자 값
            int remain = (pool.end - now) % L;
            // 사용한 판자 개수
            board += (pool.end - now) / L;
            // 현재 위치 갱신
            now = pool.end;
            if (remain > 0) {
                board++;
                now += L - remain;
            }
        }

        System.out.println(board);
    }
}