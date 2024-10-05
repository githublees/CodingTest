import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 부배열 쌍
        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {
                 sum += A[j];
                 sumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {

            int sum = 0;

            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        int aSize = sumA.size();
        int bSize = sumB.size();

        long cnt = 0;
        int left = 0;
        int right = bSize - 1;

        while (left < aSize && right >= 0) {

            int sum = sumA.get(left) + sumB.get(right);

            if (sum == T) {

                int a = sumA.get(left);
                int b = sumB.get(right);
                long aCnt = 0, bCnt = 0;

                while (left < aSize && sumA.get(left) == a) {
                    aCnt++;
                    left++;
                }

                while (right >= 0 && sumB.get(right) == b) {
                    bCnt++;
                    right--;
                }

                cnt += aCnt * bCnt;

            }
            else if (sum < T) {

                left++;

            }
            else if (sum > T) {

                right--;

            }
        }

        System.out.println(cnt);
    }
}