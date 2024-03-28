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
			if(vowels_consonant_check(pwd, 0, 0)) { 
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
	
	private static boolean vowels_consonant_check(StringBuilder sb, int vo, int co) {
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' 
				|| sb.charAt(i) == 'o' || sb.charAt(i) == 'u') {
				vo++;
			}
		}
		
		if(vo >= 1 && sb.length() - vo >= 2) {
			return true;			
		}
		return false;
	}
}