import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	static int isFlag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();
		isFlag = 0;
		
		change(new StringBuilder(S), new StringBuilder(T));
		
		System.out.println(isFlag);
	}
	
	private static void change(StringBuilder s, StringBuilder t) {
	
		if(s.length() == t.length()) {
			if(t.toString().equals(s.toString())) {
				isFlag = 1;				
			}
			return;
		}

		if(t.charAt(t.length()-1) == 'A' ) {
			t.deleteCharAt(t.length()-1);
			change(new StringBuilder(s), new StringBuilder(t));
			t.append("A");	
		}		
		
		if(t.charAt(0) == 'B') {
			t.reverse().deleteCharAt(t.length()-1);
			change(new StringBuilder(s), new StringBuilder(t));
			t.append("B").reverse();
		}
	}
}