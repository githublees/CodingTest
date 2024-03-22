import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] v = new int[201];
		
		int N = Integer.parseInt(sc.next());
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(sc.next());
			
			v[x+100]++;
		}
		
		int find = Integer.parseInt(sc.next());
		
		System.out.println(v[find+100]);
	}
}