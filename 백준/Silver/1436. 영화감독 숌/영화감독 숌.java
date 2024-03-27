import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		int num = 666;
		
		while(N > 0) {
			if(String.valueOf(num).contains("666")) {
				arr[N-1] = num;
				N--;
			}
			num++;
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-1]);
		
	}

}