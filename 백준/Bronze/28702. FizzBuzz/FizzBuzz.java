import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {

            String input = br.readLine();

            if (!input.equals("FizzBuzz") && !input.equals("Fizz") && !input.equals("Buzz")) {

                int number = Integer.parseInt(input) + 3 - i;
                
                if (number % 3 == 0 && number % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (number % 3 == 0 && number % 5 != 0) {
                    System.out.println("Fizz");
                } else if (number % 3 != 0 && number % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(number);
                }
                return;
            }
        }
    }
}