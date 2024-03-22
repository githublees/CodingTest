import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') 
				sb.append(String.valueOf(str.charAt(i)).toUpperCase());
			else
				sb.append(String.valueOf(str.charAt(i)).toLowerCase());
		}
		
		System.out.println(sb.toString());
	}
}