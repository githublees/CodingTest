import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		int r = Integer.parseInt(br.readLine());
		
		int depth = 1; 
		while(r > 1) {
			r -= depth++ * 6;
		}
		
		System.out.println(depth);
	}
}