import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Work implements Comparable<Work> {
        int t;
        int s;

        public Work(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Work o) {
            return o.s - this.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Work[] works = new Work[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            works[i] = new Work(T, S);
        }

        Arrays.sort(works);
        
        int time = works[0].s;
        for (int i = 0; i < N; i++) {
            time = Math.min(time, works[i].s) - works[i].t;
            if (time < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(time);
    }
}