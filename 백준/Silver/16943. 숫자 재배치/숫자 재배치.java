import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        visited = new boolean[A.length()];

        combination(A, B, 0);
        System.out.println(answer);
    }

    private static void combination(String a, int b, int start) {

        if (sb.length() == a.length() && sb.charAt(0) != '0') {
            int result = Integer.parseInt(sb.toString());
            if (result < b) {
                answer = Math.max(answer, result);
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if (visited[i]) continue;

            sb.append(a.charAt(i));
            visited[i] = true;
            combination(a, b, i+1);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}