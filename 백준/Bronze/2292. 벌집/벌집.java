import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int r = Integer.parseInt(br.readLine());
		
		int depth = 0; 
		while(r > 0) {
			if(depth == 0) r -= 1;
			else {
				r = r - depth * 6;
			}
			depth++;
		}
		
		System.out.println(depth);
	}
}