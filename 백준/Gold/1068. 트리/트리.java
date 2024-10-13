import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, D, answer = 0;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new List[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = 0;

        for (int i = 0; i < N; i++) {

            int n = Integer.parseInt(st.nextToken());

            if (n == -1) {
                start = i;
                continue;
            }

            tree[n].add(i);
        }

        D = Integer.parseInt(br.readLine());

        findLeafNode(start);

        System.out.println(answer);
    }

    private static void findLeafNode(int node) {

        if (node == D) return;

        int child = 0;

        for (int nxt : tree[node]) {

            if (nxt != D) {
                child++;
            }

            findLeafNode(nxt);
        }

        if (child == 0) {
            answer++;
        }
    }
}