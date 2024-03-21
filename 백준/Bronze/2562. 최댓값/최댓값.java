import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = Integer.MIN_VALUE;
		int n = 0;
		
		int[] number = new int[9];
		for(int t=0; t<9; t++) {
			number[t] = Integer.parseInt(br.readLine());
			if(max < number[t]) {
				n = t;
				max = number[t];
			}
		}
		
		System.out.println(number[n]+ "\n" + (n+1));
	}

}