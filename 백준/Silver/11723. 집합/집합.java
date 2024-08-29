import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];

        while (M --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            int x = 0;

            if (!order.equals("all") && !order.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (order) {
                case "add" :
                    set[x] = true;
                    break;
                case "remove" :
                    set[x] = false;
                    break;
                case "check" :
                    sb.append(set[x] ? 1 : 0).append("\n");
                    break;
                case "toggle" :
                    set[x] = !set[x];
                    break;
                case "all" :
                    Arrays.fill(set, true);
                    break;
                case "empty" :
                    Arrays.fill(set, false);
                    break;
            }
        }

        System.out.println(sb);
    }
}