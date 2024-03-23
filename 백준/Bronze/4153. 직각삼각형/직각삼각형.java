import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(Integer.parseInt(st.nextToken()));
		pq.offer(Integer.parseInt(st.nextToken()));
		pq.offer(Integer.parseInt(st.nextToken()));
		
		int Ausar =  pq.poll();
		int Auset =  pq.poll();
		int Heru = pq.poll();
			
		do {
			
			String msg = Math.pow((double) Heru, 2) == Math.pow((double) Ausar, 2) + Math.pow((double) Auset, 2) ? "right" : "wrong";
			System.out.println(msg);
			
			st = new StringTokenizer(br.readLine());
			
			pq = new PriorityQueue<>();
			pq.offer(Integer.parseInt(st.nextToken()));
			pq.offer(Integer.parseInt(st.nextToken()));
			pq.offer(Integer.parseInt(st.nextToken()));
			
			Ausar =  pq.poll();
			Auset =  pq.poll();
			Heru = pq.poll();
			
		} while (Ausar != 0 && Auset != 0 && Heru != 0);
	}
}