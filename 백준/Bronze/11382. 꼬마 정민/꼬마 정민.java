import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long result = Long.parseLong(sc.next());
		result += Long.parseLong(sc.next());
		result += Long.parseLong(sc.next());
		
		System.out.println(result);
	}
}