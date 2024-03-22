import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet set = new HashSet<Integer>();

		for(int i=1; i<=30; i++) {
			set.add(i);
		}
		
		for(int i=0; i<28; i++) {
			set.remove(Integer.parseInt(br.readLine()));
		}
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}