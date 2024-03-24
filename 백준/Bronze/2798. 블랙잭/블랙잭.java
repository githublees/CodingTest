import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static int max = Integer.MAX_VALUE;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] card = new int[N];
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visit = new boolean[N];
		combination(card, visit, 0, N, 0, M);
		
		System.out.println(result);
	}

	public static void combination(int[] card, boolean[] visit, int start, int n, int r, int m) {
		if(r == 3) {
			int sum = 0;
			for(int j=0; j<n; j++) {
				if(visit[j]) sum += card[j];
			}
			
			if(m - sum < max && m - sum >= 0) {
				result = sum;
				max = m - sum;
			}
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(visit[i]) continue;
			
			visit[i] = true;
			combination(card, visit, i, n, r+1, m);
			visit[i] = false;
		}
	}
}