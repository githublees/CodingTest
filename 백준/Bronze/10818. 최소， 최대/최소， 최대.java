import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		String[] arr = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			int ps = Integer.parseInt(arr[i]);
			max = Math.max(max, ps);
			min = Math.min(min, ps);
		}
		
		System.out.println(min + " " + max);
	}
}