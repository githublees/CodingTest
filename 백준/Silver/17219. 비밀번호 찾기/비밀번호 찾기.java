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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        while (N --> 0) {

            st = new StringTokenizer(br.readLine());

            String address = st.nextToken();
            String password = st.nextToken();

            map.put(address, password);

        }

        while (M --> 0) {

            String address = br.readLine();

            sb.append(map.get(address)).append("\n");

        }

        System.out.println(sb);
    }
}