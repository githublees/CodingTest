import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        String answer = Integer.toBinaryString(K + 1).replace('0', '4').replace('1', '7');
        System.out.println(answer.substring(1));;
    }
}