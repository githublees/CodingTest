import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int tc=0; tc<T; tc++) {
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n == 1) continue;
			
			int cnt = 0;
			
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(cnt > 1) break;
				
				if(n%i == 0) cnt++;
			}
			
			if(cnt == 0) result++;
		}
		
		System.out.println(result);
	}
}