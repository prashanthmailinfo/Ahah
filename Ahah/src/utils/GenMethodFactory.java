/**
 * 
 */
package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class GenMethodFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 6, -10, 1, 4, 8, 9, 7, -1, 14, 32 };
		int[] m = { -10, 1, 4, 8, 9,};
		int[] n = { -7, -1, 14, 32 };
//		pp(ms(a));
		HeapS(a);
		pp(a);
	}


	public static void minHeap(int[] a,int length,int index){
		int heapSize = length;
		int minIndex = index;
		int lChild = (index << 1) + 1;
		int rChild = (index << 1) + 2;
		if (lChild < heapSize && a[index] > a[lChild]) {
			minIndex = lChild;
		}
		if (rChild < heapSize && a[minIndex] > a[rChild]) {
			minIndex = rChild;
		}
		if(minIndex != index){
			int tmp = a[index];
			a[index] = a[minIndex];
			a[minIndex] = tmp;
			minHeap(a, length,minIndex);
		}
	}
	
	
	public static void HeapS(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			minHeap(a, a.length, i);
		}
		for (int i = a.length - 1; i > 0; i--) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			minHeap(a, i, 0);
		}
	}

	/**
	 * @param arrayList
	 * @param k
	 */
	public static void findMaxK(ArrayList<Integer> arrayList, int k) {
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		for (int i = 0; i < arrayList.size(); i++) {
			replaceMin(tmpList, arrayList.get(i), k);
		}
		System.out.println(tmpList.toString());
	}
	
	public static void pp(int[] a){
		for(int i:a){
			System.out.print(i+",");
		}
		System.out.print("\n");
	}
	
	
	private static ArrayList<Integer> replaceMin(ArrayList<Integer> arrayList,
			int m, int k) {
		if (arrayList.size() < k) {
			arrayList.add(m);
			if (arrayList.size() == k) {
				for (int i = 1; i < k; i++) {
					int tmp = arrayList.get(i);
					int j = i;
					for (; j > 0 && tmp < arrayList.get(j - 1); j--) {
						arrayList.set(j, arrayList.get(j - 1));
					}
					arrayList.set(j, tmp);
				}
			}
		} else {

			for (int i = k - 1; i > 0; i--) {
				if (arrayList.get(i) < m) {
					for (int j = 0; j < i; j++) {
						arrayList.set(j, arrayList.get(j + 1));
					}
					arrayList.set(i, m);
					break;
				}
			}

		}
		return arrayList;
	}


	public static int[] ms(int[] a){
		if(a.length ==1)return a;
		int halfArray = a.length/2;
		int[] array0 = new int[halfArray];
		int[] array1 = new int[a.length - halfArray];
//		System.arraycopy(src, srcPos, dest, destPos, length)
		for(int i=0;i<a.length;i++){
			if(i<halfArray){
				array0[i] = a[i];
			}else{
				array1[i-halfArray] = a[i];
			}
		}
		array0 = ms(array0);
		array1 = ms(array1);
		return mergeSub(array0, array1);
	}
	// merge sorted array
	public static int[] mergeSub(int[] a, int[] b) {
		int[] result = new int[a.length+b.length];
		int i = 0,j =0,k = 0;
		while (true) {
			if(a[i]<b[j]){
				result[k] = a[i];
				if(++i>a.length - 1)break;
			}else{
				result[k] = b[j];
				if(++j>b.length - 1)break;
			}
			k++;
		}
		for (; i < a.length; i++)
			result[++k] = a[i];
		for (; j < b.length; j++)
			result[++k] = b[j];
		
		return result;
	}
	
	public static int[] qs(int[] a, int left, int right){
		int i = left;
		int j = right;
		if(left<right){
			int pivot = a[left];
			while(i<j){
				while(i<j && a[j]>pivot)j--;
				if(i<j){
					a[i] = a[j];
				}
				while(i<j && a[i]<pivot)i++;
				if(i<j){
					a[j] = a[i];
				}
			}
			a[i] = pivot;
			qs(a, left, i);
			qs(a, i, right);
		}
		return a;
	}
	
	
	public static int[] popSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				int tmp;
				if (a[j] < a[j - 1]) {
					tmp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = tmp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.print("\n");
		return a;
	}

	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j;
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
	
	/**
	 * @param a
	 * @return
	 */
	public static int getLongOptmize(int[] a) {
		int m = a.length;
		int nCurrent = a[m - 1];
		int nResult = a[m - 1];
		for (int i = m - 2; i > 0; i--) {
			nCurrent = (a[i] > a[i] + nCurrent ? a[i] : a[i] + nCurrent);
			nResult = (nResult > nCurrent ? nResult : nCurrent);
		}
		System.out.println(nResult);
		return nResult;
	}

	/**
	 * @param a
	 * @return
	 */
	public static int getLong(int[] a) {
		int max_result = a[0];

		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				if (sum > max_result) {
					max_result = sum;
				}
			}
		}
		System.out.println(max_result);
		return max_result;
	}
}
