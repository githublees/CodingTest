import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		while(!str.equals("0")) {
			String[] arr = str.split("");
			
			boolean flag = false;
			for(int i=0; i<arr.length/2; i++) {
				if(!arr[i].equals(arr[arr.length-i-1])) {
					flag = true;
					break;
				}
			}
			
			System.out.println( flag ? "no" : "yes" );
			
			str = br.readLine();
		}
	}
}