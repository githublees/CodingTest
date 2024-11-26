import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] flower = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            flower[i] = Long.parseLong(st.nextToken());
        }

        long[] honeySum = new long[N+1];
        for (int i = 1; i <= N; i++) {
            honeySum[i] = honeySum[i - 1] + flower[i];
        }

        long max = 0L;
        // 벌통이 오른쪽 끝에 있고 첫번째 벌이 왼쪽 끝인 경우
        long leftPot = honeySum[N] - flower[1];

        for (int i = 2; i < flower.length-1; i++) {
            long midSum = honeySum[N] - honeySum[i];
            long sum = leftPot - flower[i] + midSum;
            max = Math.max(max, sum);
        }

        // 벌통이 왼쪽 끝에 있고 첫번째 벌이 오른쪽 끝인 경우
        long rightPot = honeySum[N-1];

        for (int i = flower.length-2; i > 0; i--) {
            long midSum = honeySum[i-1];
            long sum = rightPot - flower[i] + midSum;
            max = Math.max(max, sum);
        }

        // 벌통이 가운데 있는 경우
        for (int i = 1; i < flower.length-1; i++) {
            long sum = honeySum[i] - honeySum[1] + honeySum[N-1] - honeySum[i-1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}