import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static int[] numCnt = new int[10000];
    static Set<Integer> number;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            number.add(num);
            numCnt[num]++;
        }

        sequence(new int[M], 0);

        System.out.println(sb);
    }

    private static void sequence(int[] arr, int r) {

        if (r == M) {

            for (int n : arr) {
                sb.append(n).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int num : number) {

            if (numCnt[num] == 0) continue;

            arr[r] = num;

            numCnt[num]--;

            sequence(arr, r+1);

            numCnt[num]++;
        }


    }
}