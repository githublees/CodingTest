import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			// Kn = (K-1)n + Kn-1;
			int[] dp = new int[n+1];
			for(int i=1; i<=n; i++) {
				dp[i] = i;
			}
			
			for(int i=0; i<k; i++) {
				for(int j=1; j<=n; j++) {
					if(j==1) dp[j] = 1;
					
					dp[j] = dp[j] + dp[j-1];
				}
			}
			System.out.println(dp[n]);
		}
	}
}