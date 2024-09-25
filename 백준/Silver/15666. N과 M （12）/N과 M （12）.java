import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int N, M;

    static TreeSet<Integer> number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            number.add(Integer.parseInt(st.nextToken()));
        }
        
        sequence(new int[M], number.first(), 0);
    }

    private static void sequence(int[] arr, int first, int r) {

        if (r == M) {

            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int n : number) {

            if (n < first) continue;

            arr[r] = n;

            sequence(arr, n, r+1);
        }
    }
}