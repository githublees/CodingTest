import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        int[] order = new int[N];
        for (int i = 0; i < N; i++) {
            order[i] = map.get(br.readLine());
        }
        
        int answer = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (order[i] > order[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}