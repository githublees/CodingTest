import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> q = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			if(order.equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				q.add(n);
				
			} else if(order.equals("front")) {
				if(q.peekFirst() == null) {
					sb.append("-1").append("\n");
				} else {
					sb.append(q.peekFirst()).append("\n");
				}
				
			} else if(order.equals("back")) {
				if(q.peekLast() == null) {
					sb.append("-1").append("\n");
				} else {
					sb.append(q.peekLast()).append("\n");
				}
				
			} else if(order.equals("size")) {
				sb.append(q.size()).append("\n");
				
			} else if(order.equals("empty")) {
				if(q.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
				
			} else if(order.equals("pop")) {
				if(q.peekFirst() == null) {
					sb.append("-1").append("\n");
				} else {
					sb.append(q.peekFirst()).append("\n");
					q.removeFirst();
				}
			}
		}
		
		System.out.println(sb.toString());

	}

}