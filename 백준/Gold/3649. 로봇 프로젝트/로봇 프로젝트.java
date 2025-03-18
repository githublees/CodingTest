import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String t = "";
        while ((t = br.readLine()) != null) {

            int x = Integer.parseInt(t) * 10_000_000;
            int n = Integer.parseInt(br.readLine());
            int[] lego = new int[n];

            for (int i = 0; i < n; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(lego);

            sb.append(binarySearch(x, n, lego)).append("\n");
        }
        System.out.println(sb);
    }

    private static String binarySearch(int x, int n, int[] lego) {

//        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

//                int mid = (left + right) / 2;
                int sum = lego[left] + lego[right];

                if (sum == x) {
                    return "yes " + lego[left] + " " + lego[right];
                }

                if (sum < x) {
                    left += 1;
                }
                else {
                    right -= 1;
                }
            }
//        }
          return "danger";
    }
}