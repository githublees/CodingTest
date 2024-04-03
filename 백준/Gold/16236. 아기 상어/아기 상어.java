import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int start_x;
	static int start_y;

	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	static class Shark {
		int x;
		int y;
		int dist;
		
		public Shark(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];

		for(int i=0; i<N; i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) { 
					start_x = i;
					start_y = j;
					map[i][j] = 0;
				}
			}			
		}
		
		int size = 2, eat = 0, dist = 0;
		
		while(true) {
			PriorityQueue<Shark> pq = new PriorityQueue<>((o1, o2) -> 
				o1.dist != o2.dist ? Integer.compare(o1.dist, o2.dist) : 
					(o1.x != o2.x ? Integer.compare(o1.x, o2.x) : Integer.compare(o1.y, o2.y))
			);
			
			pq.offer(new Shark(start_x, start_y, 0));
			
			boolean[][] visit = new boolean[N][N];
			visit[start_x][start_y] = true;
						
			boolean isCheck = false;
			
			while(!pq.isEmpty()) {
				
				Shark shark = pq.poll();
		
				if(map[shark.x][shark.y] != 0 && map[shark.x][shark.y] < size) {
					map[shark.x][shark.y] = 0;
					start_x = shark.x;
					start_y = shark.y;
					eat++;
					dist += shark.dist;
					
					isCheck = true;
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nx = shark.x + dx[d];
					int ny = shark.y + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || map[nx][ny] > size) continue;
					
					pq.offer(new Shark(nx, ny, shark.dist + 1));
					visit[nx][ny] = true;
				}
			}
			
			if(!isCheck) break;
			
			if(size == eat) {
				size++;
				eat = 0;
			}
		}
		
		System.out.println(dist);
	}
}