import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Integer> list;
    static int[] numbers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int n : list) {
            sb.append(n).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int s, int t) {

        if (numbers[s] == t) {
            list.add(t);
        }

        if (!visited[numbers[s]]) {
            visited[numbers[s]] = true;
            dfs(numbers[s], t);
            visited[numbers[s]] = false;
        }
    }
}