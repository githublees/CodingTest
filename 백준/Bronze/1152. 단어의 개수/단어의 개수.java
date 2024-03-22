import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().trim().split(" ");
		
		int result = 0;
		for(int i=0; i<str.length; i++) {
			result += str[i].equals("") ? 0 : 1;
		}
		
		System.out.println(result);
	}
}