import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] check = new boolean[31];
		for(int i=0; i<28; i++) {
			int n = Integer.parseInt(br.readLine());
			check[n] = true;
		}
		
		for(int i=1; i<=30; i++) {
			if(!check[i]) System.out.println(i);
		}
    }
}