import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = Integer.MAX_VALUE;
		int[] five = new int[9999];
		int sugar = Integer.parseInt(br.readLine());
		
		five[0] = 0;
		five[1] = 5;
		for(int i=1; i<=(sugar/5)+1; i++) {
			
			if((sugar - five[i-1]) % 3  == 0) {
				result = Math.min(result, (i-1) + (sugar - five[i-1])/3);
			}
			five[i] = five[i-1] + 5;
		}
		
		result = (result == Integer.MAX_VALUE) ? -1 : result;
		
		System.out.println(result);

	}
}