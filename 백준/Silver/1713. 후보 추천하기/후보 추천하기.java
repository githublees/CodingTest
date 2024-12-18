import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {

            int studentId = Integer.parseInt(st.nextToken());

            if (map.containsKey(studentId)) {
                map.put(studentId, map.get(studentId) + 1);
            }
            else {
                if (map.size() == N) {
                    int minId = map.entrySet().stream()
                            .min(Map.Entry.comparingByValue())
                            .get()
                            .getKey();
                    map.remove(minId);
                }
                map.put(studentId, 1);
            }

        }

        map.keySet().stream()
                .sorted().forEach(id -> System.out.print(id + " "));
    }
}