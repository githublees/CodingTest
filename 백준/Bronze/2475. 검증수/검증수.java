import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		for(int i=0; i<5; i++) {
			result += Math.pow(Long.parseLong(st.nextToken()), 2);
		}
		
		System.out.println(result%10);
	}
}