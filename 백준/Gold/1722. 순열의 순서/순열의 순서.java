import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static long[] F = new long[21];
    static int[] S = new int[21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());
        
        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        if (Q == 1) {
            long k = Long.parseLong(st.nextToken());
            
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (F[N - i - 1] < k) {
                        k -= F[N - i - 1];
                    }
                    else {
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.print(S[i] + " ");
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            long ans = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < S[i]; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    ans += F[N - i - 1];
                }
                visited[S[i]] = true;
            }
            System.out.println(ans);
        }
    }
}