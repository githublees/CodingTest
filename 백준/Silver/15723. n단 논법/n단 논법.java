import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static List<Character>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new List[123];
        for (int i = 96; i < 123; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String is = br.readLine();
            char x = is.charAt(0);
            char y = is.charAt(is.length()-1);

            graph[x].add(y);
        }


        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String is = br.readLine();
            char x = is.charAt(0);
            char y = is.charAt(is.length()-1);

            bfs(x, y);
        }
    }

    private static void bfs(char x, char y) {
        Queue<Character> q = new LinkedList<>();
        q.offer(x);

        while (!q.isEmpty()) {
            char p = q.poll();

            if (p == y) {
                System.out.println("T");
                return;
            }

            for (char c : graph[p]) {
                q.offer(c);
            }
        }
        System.out.println("F");
    }
}