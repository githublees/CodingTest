import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = Long.parseLong(sc.next());
		long M = Long.parseLong(sc.next());

		System.out.println(Math.abs(N-M));
	}
}