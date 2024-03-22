import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int prev = first;
		for(int i=0; i<7; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(Math.abs(prev - now) > 1 ) {
				System.out.println("mixed");
				return;
			}
			prev = now;
		}
		if(first == 1) {
			System.out.println("ascending");
		}else {
			System.out.println("descending");
		}	
	}
}