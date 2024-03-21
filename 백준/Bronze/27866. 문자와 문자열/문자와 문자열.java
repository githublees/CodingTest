import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] word = br.readLine().split("");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(word[n-1]);
	}

}