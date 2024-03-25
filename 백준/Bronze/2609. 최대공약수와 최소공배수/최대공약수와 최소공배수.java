import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 유클리드 호제법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// lcm(A, B) = A * B / gcd(A, B);
		System.out.println(A * B / gcd(A, B));
	}
	
	// gcd(A, B) == gcd(B, R) 단, R은 0이 아니어야 한다.
	public static int gcd(int a, int b) {
		if(a % b == 0) {
			System.out.println(b);
			return b; 
		} else
			return gcd(b, a%b);
	}
}