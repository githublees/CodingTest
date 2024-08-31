import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String sub = String.valueOf(A).concat(String.valueOf(B));
        int result = Integer.parseInt(sub) - C;

        StringBuilder sb = new StringBuilder();
        
        sb.append(A+B-C).append("\n").append(result);

        System.out.println(sb);
    }
}