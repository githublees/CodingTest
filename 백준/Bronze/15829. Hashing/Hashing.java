import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long hash = 0;
		int l = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		
		for(int i=0; i<l; i++) {
			long r = 1;
			
			for(int j=1; j<=i; j++) {
				r = ((r  * 31) % 1234567891);
			}
			
			hash = ((hash % 1234567891) + ((ch[i]- 96) * r ) % 1234567891 ) % 1234567891;
		}
		
		System.out.println(hash);
	}
}