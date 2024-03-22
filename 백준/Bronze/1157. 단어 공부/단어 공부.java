import java.io.*;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		
		String[] str  = br.readLine().toUpperCase().split("");
		
		for(int i=0; i<str.length; i++) {
			map.put(str[i], map.getOrDefault(str[i], 0) + 1);
		}
		
		String alpha = "";
		int max = Integer.MIN_VALUE;
		for(String s : map.keySet()) {
			if(max == map.get(s)) {
				alpha = "?";
			} else if(max < map.get(s)) {
				alpha = s;
				max = map.get(s);
			}
		}
		
		System.out.println(alpha);
	}
}