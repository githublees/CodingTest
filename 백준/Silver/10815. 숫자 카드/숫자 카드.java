import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[] card, find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());

        find = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        for (int f : find) {
            sb.append(binarySearch(f)).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int f) {

        int start = 0;
        int end = card.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (card[mid] < f) {
                start = mid + 1;
            }
            else if (card[mid] > f) {
                end = mid - 1;
            }
            else {
                return 1;
            }

        }

        return 0;

    }
}