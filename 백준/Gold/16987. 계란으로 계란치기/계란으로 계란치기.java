import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int N;
    static Egg[] eggs;

    static class Egg {
        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(s, w);
        }

        solution(0, 0);
        System.out.println(max);
    }

    private static void solution(int index, int count) {

        if (count == N - 1 || index == N ) {
            max = Math.max(max, count);
            return;
        }

        if (eggs[index].s <= 0) {
            solution(index + 1, count);
        }
        else {
            for (int i = 0; i < N; i++) {

                if (i == index) {
                    continue;
                }

                if (eggs[i].s > 0) {
                    eggs[index].s -= eggs[i].w;
                    eggs[i].s -= eggs[index].w;
                    solution( index + 1, count +
                            (eggs[i].s <= 0 ? 1 : 0) + (eggs[index].s <= 0 ? 1 : 0));
                    eggs[index].s += eggs[i].w;
                    eggs[i].s += eggs[index].w;
                }
            }
        }
    }
}