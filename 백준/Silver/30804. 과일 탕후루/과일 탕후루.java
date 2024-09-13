import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] fruits = new int[N];

        Map<Integer, Integer> kind = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, answer = 0;
        
        for (int end = 0; end < N; end++) {
            
            kind.put(fruits[end], kind.getOrDefault(fruits[end], 0) + 1);
            
            while (kind.size() > 2) {
                kind.put(fruits[start], kind.get(fruits[start]) - 1);
                
                if (kind.get(fruits[start]) == 0) {
                    kind.remove(fruits[start]);
                }
                
                start++;
            }
            
            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);

    }
}