import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            Map<String, Integer> map = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            while (n --> 0) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                st.nextToken();

                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);

            }

            int result = 1;

            for (int val : map.values()) {
                
                result *= (val + 1);
                
            }
            
            sb.append(result - 1).append("\n");
            
        }

        System.out.println(sb);
    }
}