import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int D, N, min;
    static int[] oven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        oven = new int[D+1];

        st = new StringTokenizer(br.readLine());
        
        oven[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
            oven[i] = Math.min(oven[i-1], oven[i]);
        }

        min = D+1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int size = Integer.parseInt(st.nextToken());
            binarySearch(size, 0, min - 1);
        }

        System.out.println(min);
    }

    private static void binarySearch(int size, int start, int end) {
        while (start <= end) {

            int mid = (start + end) / 2;

            if (size <= oven[mid]) {
                start = mid + 1;
                min = mid;
            } else {
                end = mid - 1;
            }
        }
    }
}