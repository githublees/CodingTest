import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, N, M;
    static int[] importance;

    static class Orders {
        int n;
        int i;

        public Orders (int n, int i) {
            this.n = n;
            this.i = i;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            importance = new int[10];

            Queue<Orders> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {

                int x = Integer.parseInt(st.nextToken());

                importance[x]++;

                Orders orders = new Orders(i, x);

                q.offer(orders);
            }

            int index = 0;
            while (!q.isEmpty()) {

                Orders o = q.poll();

                if (isImportantCheck(o.i)) {

                    q.offer(o);

                } else {

                    importance[o.i]--;

                    if (o.n == M) {
                        System.out.println(index+1);
                    }

                    index++;
                }
            }
        }
    }

    private static boolean isImportantCheck(int x) {

        for (int i = x; i < 10; i++) {
            if (i != x && importance[i] > 0) {
                return true;
            }
        }
        return false;
    }
}