import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for(int i=1; i<N; i++) {
			
			int M = 0, div = 1;
			while(i >= div) {
				M += ( i % (div*10) ) / div;
				div *= 10;
			}
			
			if(i + M == N) {
				result = i;
				break;
			}
			
		}
		
		System.out.println(result);
	}
}