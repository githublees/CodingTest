import java.io.*;

public class Main {

	public static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
//		quickSort(0, num.length-1);
		countingSort();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(num[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	/*
	 *  버블 정렬 O(n^2)
	 */
	public static void bubbleSort() {
		int temp = 0;
		for(int i=0; i< num.length; i++) {
			for(int j=1; j<num.length-i; j++) {
				if(num[j-1] > num[j]) {
					temp = num[j-1];
					num[j-1] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	
	/*
	 *  삽입 정렬 O(N), 최악의 경우 O(n^2)
	 */
	public static void insertionSort() {
		for(int i=1; i<num.length; i++) {
			int temp = num[i];
			int prev = i - 1;
			while((prev >= 0) && (num[prev] > temp)) {
				num[prev+1] = num[prev];
				prev--;
			}
			num[prev+1] = temp;
		}
	}
	
	/*
	 *  퀵 정렬 O(nlogn), 최악의 경우 O(n^2)
	 */
	public static void quickSort(int left, int right) {
		if(left >= right) return;
		
		int pivot = partitions(left, right);
		
		quickSort(left, pivot-1);
		quickSort(pivot+1, right);
	}
	
	private static int partitions(int left, int right) {

		int mid = (left + right) / 2;
		swap(left, mid);

		int pivot = num[left]; // 가장 왼쪽값을 피벗으로 설정
		int i = left, j = right;
		
		while(i < j) {
			
			// 오른쪽에서부터 pivot 보다 작은 값을 찾는다.
			while(pivot < num[j]) j--;
			
			// 왼쪽에서부터 pivot 보다 큰 값을 찾으면서 i 가 j 보다 작으면 i++
			while (i < j && pivot >= num[i]) i++;
			
			swap(i, j);
		}
		// pivot인 왼쪽값에 현재 i값을 넣고 i값에는 pivot으로 설정했던 왼쪽값을 넣는다.
		num[left] = num[i];
		num[i] = pivot;
		
		// i를 기준으로 파티션을 나누도록 i 반환
		return i;
	}
	
	private static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	/*
	 * 계수 정렬, 정렬하는 숫자가 특정한 범위 내에 있을 때 사용
	 * 최선의 경우 O(nlogn)의 시간 복잡도, 최악의 경우 O(n)의 시간복잡도
	 */
	public static void countingSort() {
		int[] sorted_num = new int[num.length];
		
		// 1) counting 배열의 사이즈를 최대값이 담기도록 크게 잡기
		// 때문에 메모리 낭비가 심하다.
		int[] counting = new int[100001];
		
		// 2) counting 배열의 값을 증가해주기
		for(int i=0; i<num.length; i++) {
			counting[num[i]]++;
		}
		
		// 3) counting 배열을 누적합으로 만들어주기.
		for(int i=1; i<counting.length; i++) {
			counting[i] += counting[i-1];
		}
		
		// 4) 뒤에서부터 배열을 돌면서, 해당하는 값의 인덱스에 값을 넣어주기
		for(int i=num.length-1; i>=0; i--) {
			counting[num[i]]--;
			sorted_num[counting[num[i]]] = num[i];
		}
		
		num = sorted_num;
	}
}