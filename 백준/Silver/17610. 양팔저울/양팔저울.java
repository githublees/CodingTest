import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] weight;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        weight = new int[k];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            sum += weight[i];
        }
        
        answer = new boolean[sum + 1];
        
        combination(0, 0);

        int total = 0;
        for (int i = 1; i <= sum; i++) {
            if (!answer[i]) {
                total++;
            }
        }
        System.out.println(total);
    }

    private static void combination(int idx, int sum) {

        if (idx < k) {
            combination(idx + 1, sum);
            combination(idx + 1, sum + weight[idx]);
            combination(idx + 1, sum - weight[idx]);
        }
        
        if (idx == k && sum > 0) {
            answer[sum] = true;
        }
    }
}