import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
//		quickSort(A, 0, A.length-1);
		mergeSort(A, 0, A.length-1);
		
		 StringBuilder sb = new StringBuilder(); 
		 for(int i=0; i<A.length; i++) {
			 sb.append(A[i]).append("\n"); 
		 }
		  
		 System.out.println(sb.toString());
	}
	
	public static void mergeSort(int[] num, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			
			mergeSort(num, left, mid);
			mergeSort(num, mid+1, right);
			
			merge(num, left, mid, right);
		}
	}
	
	public static void merge(int[] num, int left, int mid, int right) {
		int[] L = Arrays.copyOfRange(num, left, mid+1);
		int[] R = Arrays.copyOfRange(num, mid+1, right+1);
		
		int i = 0, j = 0, k = left;
		int ll = L.length, rl = R.length;
		
		while(i < ll && j < rl) {
			if(L[i] <= R[j]) {
				num[k] = L[i++];
			} else {
				num[k] = R[j++];
			}
			k++;
		}
		
		while(i < ll) {
			num[k++] = L[i++];
		}
		
		while(j < rl) {
			num[k++] = R[j++];
		}
	}
	
//	public static int partition(int[] num, int left, int right) {
//		int pivot = num[left];
//		int lo = left, hi = right;
//		
//		while(lo < hi) {
//			while(pivot < num[hi]) hi--;
//			while(lo < hi && pivot >= num[lo]) lo++;
//			
//			swap(num, lo, hi);
//		}
//		num[left] = num[lo];
//		num[lo] = pivot;
//		
//		return lo;
//	}
//	
//	public static void quickSort(int[] num, int left, int right) {
//		/*
//		 * left가 right보다 크거나 같다면 정렬 할 원소가 
//		 * 1개 이하이므로 정렬하지 않고 return한다.
//		 */
//		if(left >= right) return;
//		
//		int pivot = partition(num, left, right);
//		
//		quickSort(num, left, pivot-1);
//		quickSort(num, pivot+1, right);
//	}
//
//	public static void swap(int[] num, int i, int j) {
//		int temp = num[i];
//		num[i] = num[j];
//		num[j] = temp;
//	}
}