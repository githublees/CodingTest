import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, H;
    static int[] up;
    static int[] down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        up = new int[N/2];
        down = new int[N/2];

        for (int i = 0; i < N/2; i++) {
            up[i] = Integer.parseInt(br.readLine());
            down[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = N;
        int count = 0;

        for (int i = 1; i < H+1; i++) {
            int countWall = solve(i, up) + solve(H-i+1, down);

            if (min == countWall) {
                count++;
            } else if (min > countWall) {
                min = countWall;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }

    private static int solve(int h, int[] arr) {
        /* h 가 찾고자하는 높이일 때,
           이분탐색을 하여 arr[mid] 와 h 가 같거나 큰
           right 의 최소값을 찾으면 그 뒤의 장애물은 무조건 지나므로
           arr.length - right;
         */
        int left = 0;
        int right = N / 2;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }
}