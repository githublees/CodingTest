import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n, answer;
    static int[] student;
    static boolean[] visited, done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            n = Integer.parseInt(br.readLine());
            
            answer = 0;
            student = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }

            sb.append(n - answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs (int idx) {
        // 이전에 이미 검사했다는 뜻
        if (done[idx]) return;
        // 방문을 했었다는 사이클이라는 뜻이므로
        if (visited[idx]) {
            // 다시 방문하지 않기 위해 done[idx] = true
            done[idx] = true;
            // 사이클이므로 +1
            answer++;
        }
        // 방문 체크
        visited[idx] = true;
        dfs(student[idx]);
        // 사이클에 포함되지 않았어도
        done[idx] = true;
        // 방문 체크 초기화
        visited[idx] = false;
    }

}