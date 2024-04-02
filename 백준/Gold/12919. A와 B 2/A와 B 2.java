import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();
		
		System.out.println(dfs(S, new StringBuilder(T)) ? 1 : 0);
	}
	
	private static boolean dfs(String s, StringBuilder t) {
	
		if(s.length() == t.length()) {
			
			if(t.toString().equals(s)) {
				return true;				
			}
			
			return false;
		}

		if(t.charAt(t.length()-1) == 'A' ) {
			
			t.deleteCharAt(t.length()-1);
			
			if(dfs(s, new StringBuilder(t))) {
				return true;
			}
			
			t.append("A");	
		}		
		
		if(t.charAt(0) == 'B') {
			
			t.reverse().deleteCharAt(t.length()-1);
			
			if(dfs(s, new StringBuilder(t))) {
				return true;
			}
		}
		
		return false;
	}
}