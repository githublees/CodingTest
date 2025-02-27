import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] beer = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            // 선호도
            max += beer[i][0] = Integer.parseInt(st.nextToken());
            // 도수 레벨
            beer[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(beer, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });

        System.out.println(findLevel(beer, N, M, K));
    }

    private static int findLevel(int[][] beer, int n, int m, int k) {

        int answer = -1;
        int total = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.offer(beer[i][0]);
            total += beer[i][0];

            if (pq.size() > n) {
                total -= pq.poll();
            }

            if (pq.size() == n && total >= m) {
                answer = beer[i][1];
                break;
            }
        }

        return answer;
    }
}