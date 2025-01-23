import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }

    private static int solution(String ab) {

        int min = Integer.MAX_VALUE;
        int aLength = 0;
        int bCount = 0;

        for (int i = 0; i < ab.length(); i++) {
            
            if (ab.charAt(i) == 'a') {
                aLength++;
            }
            
        }

        for (int i = 0; i < aLength; i++) {
            
            if (ab.charAt(i) == 'b') {
                bCount++;
            }
            
        }

        for (int i = aLength; i < ab.length() + aLength; i++) {
            
            if (ab.charAt(i % ab.length()) == 'b') {
                bCount++;
            }

            if (ab.charAt((i - aLength) % ab.length()) == 'b') {
                bCount--;
            }

            min = Math.min(min, bCount);
        }

        return min;
    }
}