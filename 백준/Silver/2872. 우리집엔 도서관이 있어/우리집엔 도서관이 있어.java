import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> dictionary = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int order = 0; order < N ; order++) {
            int book = Integer.parseInt(br.readLine());
            dictionary.add(book);
        }

        int result = 0, order = N;

        for (int position = N-1; position >= 0 ; position--) {
            if (dictionary.get(position) == order) {
                order--;
            } else {
                result++;
            }
        }

        System.out.println(result);

    }
}