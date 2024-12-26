import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<Integer> energy = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energy.add(Integer.parseInt(st.nextToken()));
        }

        merge(energy, 0);
        System.out.println(max);
    }

    private static void merge(List<Integer> energy, int sum) {
        
        if (energy.size() == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < energy.size() - 1; i++) {
            int temp = energy.get(i);
            int value = energy.get(i - 1) * energy.get(i + 1);

            energy.remove(i);
            merge(energy, sum + value);
            energy.add(i, temp);
        }
    }
}