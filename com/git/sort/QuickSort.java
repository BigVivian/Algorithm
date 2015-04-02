package com.git.sort;

import java.util.Random;

/**
 * 快速排序(不稳定)
 * 
 * 平均时间：O(nlogn) 最好时间：O(nlogn) 最坏时间：O(n^2)<br>
 * 
 * 1.在数组中，任意选取一个元素x作为中间值，比x小的移到数组的左边，比x大的移到数组的右边;<br>
 * 2.重复调用过程，直到下标 start >= end;<br>
 * 
 * @author Vivian
 * 
 */
public class QuickSort {

	public void sort(int[] a, int start, int end) {

		int index = partition(a, start, end);

		// 重复调用
		if (index - 1 > start) {
			sort(a, start, index - 1);
		}
		if (index + 1 < end) {
			sort(a, index + 1, end);
		}
	}

	// 随机选定元素x，比x小的放在左边，比x大的放在右边
	private int partition(int[] a, int start, int end) {
		int index = getRandom(start, end);
		swap(a, index, end);

		int small = start - 1;
		for (int i = start; i <= end - 1; i++) {
			if (a[i] <= a[end]) {
				small++;
				if (small != i) {
					swap(a, small, i);
				}
			}
		}
		small++;
		swap(a, small, end);

		return small;
	}

	// 返回[start, end]的随机数
	private int getRandom(int start, int end) {
		Random r = new Random();
		int index = start + (int) (Math.abs(r.nextInt()) % (end - start));

		System.out.println("start = " + start + "end = " + end + "index = "
				+ index);
		return index;
	}

	// 交换元素
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 5, 4, 4, 44, 3, 2, 1, -1, 45, -1 };
		QuickSort test = new QuickSort();
		test.sort(a, 0, a.length - 1);

		for (int i = 0; i <= a.length - 1; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
