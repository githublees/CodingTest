import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] party;
    static int[] parent;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 사람 수
        N = Integer.parseInt(st.nextToken());

        // 파티의 수
        M = Integer.parseInt(st.nextToken());

        // 파티 초기화
        party = new List[M];

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        // 진실을 아는 사람 수
        int k = Integer.parseInt(st.nextToken());

        // 진실 유무
        int[] knows = new int[k];

        for (int i = 0; i < k; i++) {

            knows[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            // 해당 파티에 오는 사람 수
            int come = Integer.parseInt(st.nextToken());

            for (int j = 0; j < come; j++) {

                // 오는 사람 번호
                int num = Integer.parseInt(st.nextToken());

                party[i].add(num);
            }
        }

        parent = new int[N+1];

        for (int i = 0; i <= N; i++) {
           parent[i] = i;
        }

        for (int i = 0; i < M; i++) {

            for (int j = 1; j < party[i].size(); j++) {
                union(party[i].get(0), party[i].get(j));
            }

        }

        for (int i = 0; i < M; i++) {

            boolean isFlag = true;

            for (int j = 0; j < k; j++) {
                if (find(party[i].get(0)) == find(knows[j])) {
                    isFlag = false;
                    break;
                }
            }

            if (isFlag) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}