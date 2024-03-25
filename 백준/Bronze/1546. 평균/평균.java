import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, score[i]);
		}
		
		double avg = 0;
		for(int i=0; i<N; i++) {
			avg += ((double)score[i] / max) * 100;
		}
		
		System.out.println(avg/N);
	}

}