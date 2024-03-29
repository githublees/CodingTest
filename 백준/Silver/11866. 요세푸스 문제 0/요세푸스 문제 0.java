import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		int n = 1;
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(n % K == 0) {
				result.add(p);
				n = 0;
				
			}else {
				q.offer(p);				
			}
			
			n++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0; i<result.size()-1; i++) {
			sb.append(result.get(i)).append(", ");
			
		}
		sb.append(result.get(result.size()-1)).append(">");
		
		System.out.println(sb.toString());
	}
}