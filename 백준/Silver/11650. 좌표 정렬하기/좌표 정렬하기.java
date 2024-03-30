import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos p) {
			if(this.x == p.x) {
				return this.y - p.y;
			}
			return this.x - p.x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Pos> p = new ArrayList<>();
		for(int tc=0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			p.add(new Pos(x, y));
		}
		
		Collections.sort(p);
		for(Pos o : p) {
			System.out.println(o.x + " " + o.y);
		}
	}

}