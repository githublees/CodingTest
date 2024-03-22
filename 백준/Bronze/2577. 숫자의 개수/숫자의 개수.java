import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String[] calc = String.valueOf(A * B * C).split("");
		
		int[] num = new int[10];
		for(int i=0; i<calc.length; i++) {
			num[Integer.parseInt(calc[i])]++;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(num[i]);
		}
	}
}