import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] matrix_1 = new int[N][M];
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N*2; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				if(i >= N) {
					matrix_1[i%N][j] += Integer.parseInt(st.nextToken());
					sb.append(matrix_1[i%N][j]).append(" ");
				
				} else matrix_1[i][j] = Integer.parseInt(st.nextToken());
			}
			
			if(i >= N) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}