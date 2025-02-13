import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            findNextWord(br.readLine().toCharArray());
        }
        System.out.println(sb);
    }

    private static void findNextWord(char[] word) {

        int index_1 = -1;
        int index_2 = 0;

        for (int i = word.length - 1; i > 0; i--) {
            if (word[i - 1] < word[i]) {
                index_1 = i - 1;
                break;
            }
        }

        if (index_1 == -1) {
            sb.append(word).append("\n");
            return;
        }

        for (int i = word.length - 1; i > 0; i--) {
            if (word[index_1] < word[i]) {
                index_2 = i;
                break;
            }
        }
        swap(word, index_1, index_2);

        Arrays.sort(word, index_1+1, word.length);

        for (char c : word) {
            sb.append(c);
        }
        sb.append("\n");
    }

    private static void swap(char[] word, int x, int y) {
        char temp = word[x];
        word[x] = word[y];
        word[y] = temp;
    }
}