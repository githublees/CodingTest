import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			String[] input = br.readLine().split(" ");
			
			int repeat = Integer.parseInt(input[0]);
			char[] chArr = input[1].toCharArray();
			
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<chArr.length; j++) {
				for(int k=0; k<repeat; k++) {
					sb.append(chArr[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}
}