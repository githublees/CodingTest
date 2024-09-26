import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static Sequence[] A, B;

    static class Sequence {
        int index;
        int value;

        public Sequence (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new Sequence[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = new Sequence(i, Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        B = new Sequence[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B[i] = new Sequence(i, Integer.parseInt(st.nextToken()));
        }

        solve();
    }

    private static void solve() {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(A, (o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.index - o2.index;
            }
            return o2.value - o1.value;
        });

        Arrays.sort(B, (o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.index - o2.index;
            }
            return o2.value - o1.value;
        });

        int aIdx = 0, bIdx = 0, aLimit = 0, bLimit = 0;

        while (aIdx < N && bIdx < M) {

            if (A[aIdx].value == B[bIdx].value) {

                if (aLimit > A[aIdx].index) aIdx++;
                else if (bLimit > B[bIdx].index) bIdx++;
                else {
                    aLimit = A[aIdx].index;
                    bLimit = B[bIdx].index;
                    list.add(A[aIdx].value);
                    aIdx++;
                    bIdx++;
                }

            } else if (A[aIdx].value > B[bIdx].value) aIdx++;
            else bIdx++;

        }

        System.out.println(list.size());
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}