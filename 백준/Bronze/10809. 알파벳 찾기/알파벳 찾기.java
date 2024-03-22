import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		int[] alpha = new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch = br.readLine().toCharArray();
		
		for(int i=0; i<ch.length; i++) {
			if(alpha[ch[i] - 97] == -1)
				alpha[ch[i] - 97] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<alpha.length; i++) {
			sb.append(alpha[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}