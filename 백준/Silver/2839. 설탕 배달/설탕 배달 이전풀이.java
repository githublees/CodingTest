import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 만들어야 하는 무게
		int answer = 0; // 총 봉지 갯수.
		int bag3 = 0; // 3kg 봉지 갯수.
		
		// 봉지 수를 최소화 하려면 최대한 5kg 봉지로 구성해야 함 -> 먼저 체크
		while(N % 5 != 0 && N >= 0) {
			bag3++; // 3kg 봉지 사용
			N -= 3; // 전체 무게 감소
			
		}
		//N이 5kg봉지로 해결이 되는 경우 or N이 음수인 경우
		answer = (N < 0) ? -1 : bag3 + N/5;
		System.out.println(answer);
	}
}
