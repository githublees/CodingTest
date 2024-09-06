import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] opinion = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            opinion[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(opinion);

        int cut = (int)Math.round((double) n * 15 / 100);
        for (int i = cut; i < n - cut; i++) {
            sum += opinion[i];
        }

        System.out.println((int)Math.round((double) sum / (n - cut * 2)));
    }
}