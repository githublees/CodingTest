import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int index;
        int weight;

        public Node (int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while (TC --> 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Node>[] graph = new List[N+1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {

                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[S].add(new Node(E, T));
                graph[E].add(new Node(S, T));
            }

            for (int i = 0; i < W; i++) {

                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                graph[S].add(new Node(E, -T));
            }

            boolean isCheck = false;

            for (int i = 1; i <= N; i++) {

                isCheck = bellmanFord(graph, i, N);

                if (isCheck) {
                    System.out.println("YES");
                    break;
                }
            }

            if (!isCheck) {
                System.out.println("NO");
            }
        }
    }

    private static boolean bellmanFord (List<Node>[] graph, int start, int N) {

        int[] times = new int[N+1];

        Arrays.fill(times, Integer.MAX_VALUE);

        times[start] = 0;
        boolean isCheck = false;

        for (int i = 1; i < N; i++) {
            isCheck = false;

            for (int j = 1; j <= N; j++) {

                for (Node nxt : graph[j]) {

                    if (times[j] != Integer.MAX_VALUE &&
                            times[nxt.index] > times[j] + nxt.weight) {
                        times[nxt.index] = times[j] + nxt.weight;
                        isCheck = true;
                    }
                }
            }

            if (!isCheck) break;
        }

        if (isCheck) {

            for (int i = 1; i <= N; i++) {

                for (Node nxt : graph[i]) {

                    if (times[i] != Integer.MAX_VALUE &&
                            times[nxt.index] > times[i] + nxt.weight) {
                        return true;
                    }
                }
            }
        }

        return false;

    }
}