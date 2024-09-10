import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {

            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());

            while (k --> 0) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                String order = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {

                    map.put(number, map.getOrDefault(number, 0) + 1);

                } else {

                    if (map.size() == 0) continue;

                    int result = 0;

                    if (number == 1) {

                        result = map.lastKey();

                    } else {

                        result = map.firstKey();

                    }

                    if (map.put(result, map.get(result) - 1) == 1) {

                        map.remove(result);

                    }
                }
            }

            if (map.size() == 0) {

                sb.append("EMPTY").append("\n");

            } else {

                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");

            }
        }

        System.out.println(sb);
    }
}