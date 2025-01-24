import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        Set<String> shortCut = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            
            String[] words = br.readLine().split(" ");

            boolean flag = false;

            for (int j = 0; j < words.length; j++) {

                String key = String.valueOf(words[j].charAt(0));
                if (!shortCut.contains(key)) {
                    shortCut.add(key.toLowerCase());
                    shortCut.add(key.toUpperCase());

                    StringBuilder sb = new StringBuilder(words[j]);
                    sb.insert(0, "[");
                    sb.insert(2, "]");
                    words[j] = sb.toString();

                    flag = true;
                    break;
                }
            }

            if (!flag) {

                boolean flag_2 = false;

                for (int j = 0; j < words.length; j++) {

                    for (int k = 0; k < words[j].length(); k++) {

                        String key = String.valueOf(words[j].charAt(k));

                        if (!shortCut.contains(key)) {
                            shortCut.add(key.toLowerCase());
                            shortCut.add(key.toUpperCase());

                            StringBuilder sb = new StringBuilder(words[j]);
                            sb.insert(k, "[");
                            sb.insert(k + 2, "]");
                            words[j] = sb.toString();

                            flag_2 = true;
                            break;
                        }
                    }

                    if (flag_2) {
                        break;
                    }
                }
            }

            for (int j = 0; j < words.length; j++) {
                result.append(words[j]).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}