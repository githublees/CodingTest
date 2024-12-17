import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] ans = new int[n];
            int left = 0, right = n-1;

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                if (i % 2 != 0) {
                    ans[left] = arr[i];
                    left++;
                }
                else {
                    ans[right] = arr[i];
                    right--;
                }
            }
            
            min = Math.abs(ans[0] - ans[n-1]);
            for (int i = 1; i < n; i++) {
                min = Math.max(min, Math.abs(ans[i] - ans[i-1]));
            }

            System.out.println(min);
        }
    }
}