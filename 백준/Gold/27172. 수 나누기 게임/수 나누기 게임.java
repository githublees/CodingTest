import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] card;
    static int[] player;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        player = new int[N];
        card = new boolean[1000001];
        score = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            card[player[i]] = true;
        }
        for (int p : player) {

            for (int i = p * 2; i < 1000001; i+=p) {

                if (card[i]) {
                    score[p]++;
                    score[i]--;
                }

            }

        }

        for (int i = 0; i < N; i++) {
            sb.append(score[player[i]]).append(" ");
        }
        System.out.println(sb);
    }
}