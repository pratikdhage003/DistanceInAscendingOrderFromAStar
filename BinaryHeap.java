package com.binaryheap;

import java.util.Arrays;

public class BinaryHeap {
	static int MIN_HEAP_LIMIT = 8;
	static int CURRENT_MIN_HEAP_INDEX = -1;
	static int[] minHeap = new int[MIN_HEAP_LIMIT];

	public static void main(String[] args) {

		Arrays.fill(minHeap, -1);

		minHeapInsert(6);

		printMinHeap();

		minHeapInsert(5);

		printMinHeap();

		minHeapInsert(3);

		printMinHeap();

		minHeapInsert(1);

		printMinHeap();

		minHeapInsert(8);

		printMinHeap();

		minHeapInsert(7);

		printMinHeap();

		minHeapInsert(2);

		printMinHeap();

		minHeapInsert(4);

		printMinHeap();

		/*
		 * 
		 * */

		System.out.println("\n\nBefore deletion CURRENT_MIN_HEAP_INDEX : " + CURRENT_MIN_HEAP_INDEX);

		deleteMin();

		System.out.println(
				"After deleting one element min heap CURRENT_MIN_HEAP_INDEX : " + CURRENT_MIN_HEAP_INDEX);

		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();

		deleteMin();
		printMinHeap();
	}

	public static void minHeapInsert(int element) {

		/*
		 * insertion in heap works in a bottom-up fashion
		 */
		if (CURRENT_MIN_HEAP_INDEX == -1) {

			CURRENT_MIN_HEAP_INDEX++;
			minHeap[CURRENT_MIN_HEAP_INDEX] = element;

		} else if (CURRENT_MIN_HEAP_INDEX >= MIN_HEAP_LIMIT - 1) {

			System.out.println("\nSorry its full...can not add further... ");
			return;

		} else if (CURRENT_MIN_HEAP_INDEX < MIN_HEAP_LIMIT - 1) {

			CURRENT_MIN_HEAP_INDEX++;
			minHeap[CURRENT_MIN_HEAP_INDEX] = element;
			int i = CURRENT_MIN_HEAP_INDEX;
			int temp = 0;

			while (minHeap[i] < minHeap[Math.abs((i - 1) / 2)] && i >= 0) {
				temp = minHeap[Math.abs((i - 1) / 2)];
				minHeap[Math.abs((i - 1) / 2)] = minHeap[i];
				minHeap[i] = temp;

				i = Math.abs((i - 1) / 2);
			}

		}

	}

	public static int deleteMin() {

		int deletedElement = minHeap[0];

		if (CURRENT_MIN_HEAP_INDEX == -1) {
			System.out.println("\nSorry heap is already empty....can not delete further");
			deletedElement = -1;
			return deletedElement;

		} else if (CURRENT_MIN_HEAP_INDEX == 0) {

			minHeap[0] = -1;
			CURRENT_MIN_HEAP_INDEX--;
			return deletedElement;

		} else {

			minHeap[0] = minHeap[CURRENT_MIN_HEAP_INDEX];
			minHeap[CURRENT_MIN_HEAP_INDEX] = -1;
			CURRENT_MIN_HEAP_INDEX--;

			minHeapify();
		}

		if (deletedElement != -1)
			System.out.println("\n\nDeleted : " + deletedElement);
		return deletedElement;

	}

	public static int minHeapify() {

		int temp = 0;
		int i = 0;

		int min = -1;
		int leftChild = -1;
		int rightChild = -1;

		while (i <= CURRENT_MIN_HEAP_INDEX) {
			leftChild = 2 * i + 1;
			rightChild = 2 * i + 2;

			if (leftChild <= CURRENT_MIN_HEAP_INDEX && minHeap[i] > minHeap[leftChild]) {
				min = leftChild;
			} else {
				min = i;
			}

			if (rightChild <= CURRENT_MIN_HEAP_INDEX && minHeap[min] > minHeap[rightChild]) {
				min = rightChild;
			}

			if (i != min) {
				temp = minHeap[i];
				minHeap[i] = minHeap[min];
				minHeap[min] = temp;

				i = min;

			} else {
				break;
			}

		}
		return rightChild;

	}

	public static void printMinHeap() {
		System.out.println("\nMin Heap contents are: ");
		for (int i = 0; i < minHeap.length; i++) {
			if (minHeap[i] != -1) {
				System.out.print(minHeap[i] + ", ");
			}
		}

	}

}
