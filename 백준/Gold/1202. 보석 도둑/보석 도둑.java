import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;

    static Gem[] gems;
    
    static int[] backpack, input;

    static class Gem {
        int weight;
        int price;

        public Gem (int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new Gem[N];
        backpack = new int[K];
        input = new int[K];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(weight, price);
        }
        
        Arrays.sort(gems, (g1, g2) -> {
            if (g1.weight == g2.weight) {
                return g2.price - g1.price;
            }
            return g1.weight - g2.weight;
        });

        for (int i = 0; i < K; i++) {

            int max_weight = Integer.parseInt(br.readLine());

            backpack[i] = max_weight;
        }

        Arrays.sort(backpack);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;

        for (int i = 0, j = 0; i < K; i++) {

            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣는다.
            while (j < N && gems[j].weight <= backpack[i]) {
                pq.offer(gems[j++].price);
            }
            
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }

        }

        System.out.println(answer);
    }
}