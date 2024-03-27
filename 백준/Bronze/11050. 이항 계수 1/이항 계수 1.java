import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp_fun(N, K);
//		System.out.println(factorial(N) / (factorial(N-K) * factorial(K)));

	}
	
	// 팩토리얼
	private static int factorial(int n) {
		if(n == 0)
			return 1;
		
		return n * factorial(n-1);
	}
	
	
	// 동적계획법
	private static void dp_fun(int n, int k) {
		int[][] dp = new int[n+1][k+1];
		
		for(int i=0; i<=n; i++) {
			dp[i][0] = 1;
		}
		for(int i=0; i<=k; i++) {
			dp[i][i] = 1;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		
		System.out.println(dp[n][k]);
	}
}