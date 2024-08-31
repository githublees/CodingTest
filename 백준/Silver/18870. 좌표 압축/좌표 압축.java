import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] position = new int[N];
        int[] sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sort[i] = position[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int x : sort) {
            if (map.containsKey(x)) continue;
            map.put(x, index++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(position[i])).append(" ");
        }

        System.out.println(sb);
    }
}