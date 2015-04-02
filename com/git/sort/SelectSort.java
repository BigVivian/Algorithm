package com.git.sort;

/**
 * 选择排序(不稳定)
 * 
 * 平均时间：O(n^2), 最好时间：O(n^2), 最坏时间：O(n^2)<br>
 * 
 * 1) 每次排序的时候都需要寻找第n小的数据，并且和array[n-1]发生交换 ;<br>
 * 2) 等到n个数据都排序好，那么选择排序结束。<br>
 * 
 * @author Vivian
 * 
 */
public class SelectSort {

	public void sort(int[] a) {

		for (int i = 0; i <= a.length - 1; i++) {
			int min = a[i];
			int minIndex = i;

			// get the min and the index of min
			for (int j = i + 1; j <= a.length - 1; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}

			// swap: Nth Number and a[n-1]
			int temp = a[i];
			a[i] = min;
			a[minIndex] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 34, 5, -1 };
		SelectSort test = new SelectSort();
		test.sort(a);
		for (int i = 0; i <= a.length - 1; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
