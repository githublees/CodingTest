import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Long[] p = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        p[0] = 0L;
        p[1] = 1L;
        p[2] = 1L;
        p[3] = 1L;

        while (T --> 0) {

            int N = Integer.parseInt(br.readLine());

            sb.append(padovan(N)).append("\n");

        }

        System.out.println(sb);

    }

//    private static long padovan(int N) {
//        if (p[N] == null) {
//            p[N] = padovan(N - 2) + padovan(N - 3);
//        }
//        return p[N];
//    }

    private static long padovan(int N) {

        for (int i = 4; i < 101; i++) {
            p[i] = p[i - 2] + p[i - 3];
        }

        return p[N];
    }
}