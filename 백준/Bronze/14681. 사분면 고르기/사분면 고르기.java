import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		int Quad = 0;
		if(x > 0) {
			Quad = y > 0 ? 1 : 4;
		}else {
			Quad = y > 0 ? 2 : 3;
		}
		
		System.out.println(Quad);
	}
}