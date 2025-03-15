import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        //찾고자 하는 숫자의 자릿수
        long length = 1;
        //찾고자 하는 숫자의 자릿수 별 갯수
        long cnt = 9;

        while (k > length * cnt) {
            k -= (length * cnt);
            length++;
            cnt *= 10;
        }

        long answer = (long)Math.pow(10, (length - 1)) + ((k - 1) / length);

        if (answer > N) {
            System.out.println(-1);
        }
        else {
            System.out.println(String.valueOf(answer).charAt((int)((k - 1) % length)));
        }
    }
}