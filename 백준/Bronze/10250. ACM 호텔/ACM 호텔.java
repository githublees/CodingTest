import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int guest = Integer.parseInt(st.nextToken());
			
			int Y = guest % H == 0 ? H : guest % H;
			int X = (int)Math.ceil((double)guest / H);
			
			StringBuilder sb = new StringBuilder();
			sb.append(Y);
			if(X > 9) {
				sb.append(X);
			}else {
				sb.append("0").append(X);
			}
			
			System.out.println(sb.toString());
		}
	}
}