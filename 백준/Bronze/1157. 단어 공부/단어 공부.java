import java.io.*;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] alpha = {
				"A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N",
				"O", "P", "Q", "R", "S", "T", "U",
				"V", "W", "X", "Y", "Z"
		};
		
		int[] num = new int[26];
		
		String[] str = br.readLine().toUpperCase().split("");
		for(int i=0; i<str.length; i++) {
			switch(str[i]) {
				case "A" :
					num[0]++;
					break;
				case "B" :
					num[1]++;
					break;
				case "C" :
					num[2]++;
					break;
				case "D" :
					num[3]++;
					break;
				case "E" :
					num[4]++;
					break;
				case "F" :
					num[5]++;
					break;
				case "G" :
					num[6]++;
					break;
				case "H" :
					num[7]++;
					break;
				case "I" :
					num[8]++;
					break;
				case "J" :
					num[9]++;
					break;
				case "K" :
					num[10]++;
					break;
				case "L" :
					num[11]++;
					break;
				case "M" :
					num[12]++;
					break;
				case "N" :
					num[13]++;
					break;
				case "O" :
					num[14]++;
					break;
				case "P" :
					num[15]++;
					break;
				case "Q" :
					num[16]++;
					break;
				case "R" :
					num[17]++;
					break;
				case "S" :
					num[18]++;
					break;
				case "T" :
					num[19]++;
					break;
				case "U" :
					num[20]++;
					break;
				case "V" :
					num[21]++;
					break;
				case "W" :
					num[22]++;
					break;
				case "X" :
					num[23]++;
					break;
				case "Y" :
					num[24]++;
					break;
				case "Z" :
					num[25]++;
					break;
			}
		}
		
		String result = "";
		int max = Integer.MIN_VALUE;
		for(int i=0; i<26; i++) {
			if(max == num[i]) {
				result = "?";
			}else if(max < num[i]){
				result = alpha[i];
				max = num[i];
			}
		}
		
		System.out.println(result);
		
//		HashMap<String, Integer> map = new HashMap<>();
//		
//		String[] str  = br.readLine().toUpperCase().split("");
//		
//		for(int i=0; i<str.length; i++) {
//			map.put(str[i], map.getOrDefault(str[i], 0) + 1);
//		}
//		
//		String alpha = "";
//		int max = Integer.MIN_VALUE;
//		for(String s : map.keySet()) {
//			if(max == map.get(s)) {
//				alpha = "?";
//			} else if(max < map.get(s)) {
//				alpha = s;
//				max = map.get(s);
//			}
//		}
//		
//		System.out.println(alpha);
	}
}