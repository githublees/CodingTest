import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String[] str = br.readLine().split("");
			
			int ans = 0, total = 0;
			for(int i=0; i<str.length; i++) {
				if(str[i].equals("O")) {
					ans++;
					total += ans;
				}else {
					ans = 0;
				}
			}
			
			System.out.println(total);
		}
	}
}