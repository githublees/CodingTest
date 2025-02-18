import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < Q; i++) {

            int duck = Integer.parseInt(br.readLine());

            // 점유된 땅 혹은 원하는 땅이 들어갈 변수
            int result = 0;

            // 시작점
            int index = duck;

            while (index != 0) {
                if (visited[index]) {
                    result = index;
                }

                // 부모 노드로
                index /= 2;
            }

            // result 가 0 이라는 것은 중간에 점유된 땅이 없다는 말이므로
            if (result == 0) {
                visited[duck] = true;
            }

            // 오리는 원하는 땅으로 갈 수 있다.
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}