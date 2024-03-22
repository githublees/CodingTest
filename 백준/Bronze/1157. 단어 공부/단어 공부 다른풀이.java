public class Main {

	public static void main(String[] args) throws Exception {
		int[] a = new int[26];
		int c, max = 0, maxa = -2;

    // 아스키 코드를 활용, 알파벳 'a'는 아스키 코드로 65
		while ((c = System.in.read()) > 64) {
      // c가 96보다 작다는 의미는 소문자라는 뜻, 소문자면 65를 빼고 대문자면 97를 뺀다.
			a[c -= c < 96 ? 65 : 97]++;

      // while을 돌면서 a[c] 위치의 알파벳이 max보다 크면 maxa에 해당 알파벳 아스키 코드를 넣는다.
			if (max < a[c]) {
				max = a[c];
				maxa = c;

      // 같으면 ?에 해당하는 아스키코드 -2를 넣는다.
			} else if (max == a[c])
				maxa = -2;
		}

    // +65를 해서 원래의 알파벳으로 출력
		System.out.print((char)(maxa + 65));
	}

}
