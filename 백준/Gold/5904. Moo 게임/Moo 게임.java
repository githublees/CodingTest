import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // S[0]일 때, 문자열의 총 길이
        int num = 3;
        // S[k-1]의 마지막 index
        int prev = 3;
        // index
        int k = 0;

        // N의 범위를 구해주기
        while (num < N) {
            k++;
            // S(K - 1) * 2 + (moo...o)
            num = prev * 2 + (1 + 2 + k);
            prev = num;
        }

        Moo(num, k);
    }

    private static void Moo(int num, int k) {

        int prev = (num - (1 + 2 + k)) / 2; // 중간을 제외한 moo 크기

        if (k == 0) {
            if (N == 1) {
                System.out.println("m");
                return;
            }
            else {
                System.out.println("o");
                return;
            }
        }

        if (N <= prev) {
            Moo(prev, k-1);
        }
        else if (N >= prev+1 && N < prev + (1 + 2 + k)) {
            if (prev + 1 == N) {
                System.out.println("m");
            } else {
                System.out.println("o");
            }
        }
        else {
            N -= (prev + (1 + 2 + k));
            Moo(prev, k-1);
        }
    }
}