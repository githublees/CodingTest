import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int hash = 0;
		int l = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		
		for(int i=0; i<l; i++) {
			hash += (ch[i] - 96) * Math.pow((double)31, i) % 1234567891;
		}
		
		System.out.println(hash);
	}
}