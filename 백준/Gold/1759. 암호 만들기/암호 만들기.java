import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		ArrayList<String> alphabet = new ArrayList<>();
		for(int i=0; i<C; i++) {
			alphabet.add(st.nextToken());
		}
		
		Collections.sort(alphabet);
		
		StringBuilder pwd = new StringBuilder();
		combination(alphabet, pwd, 0, L, C, 0);
		         
	}
	
	private static void combination(ArrayList<String> alphabet, StringBuilder pwd, int start, int l, int c, int r) {
		if(l == r) {
			
			int vo = 0;
			for(int i=0; i<r; i++) {
				if(pwd.charAt(i) == 'a' || pwd.charAt(i) == 'e' || pwd.charAt(i) == 'i' || pwd.charAt(i) == 'o' || pwd.charAt(i) == 'u') {
					vo++;
				}
			}
			
			if(vo >= 1 && pwd.length() - vo >= 2) {
				System.out.println(pwd.toString());
			}
			
			return;
		}
		
		for(int i=start; i<c; i++) {
			
			pwd.append(alphabet.get(i));
			combination(alphabet, pwd, i+1, l, c,r+1);
			pwd.deleteCharAt(pwd.length()-1);
		}
	}

}