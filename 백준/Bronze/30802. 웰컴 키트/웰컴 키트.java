import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] shirt = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            shirt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int shirts = 0;
        for (int i = 0; i < 6; i++) {
            if (shirt[i] % T > 0) {
                shirts += shirt[i] / T + 1;
            } else if (shirt[i] % T == 0) {
                shirts += shirt[i] / T;
            }
        }

        sb.append(shirts).append("\n").append(N/P).append(" ").append(N%P);
        System.out.println(sb);
    }
}