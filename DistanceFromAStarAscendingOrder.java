package com.binaryheap;

import java.util.Arrays;

public class DistanceFromAStarAscendingOrder {

	public static void main(String[] args) {

		Point ref = new Point(3, 4);

		Point a = new Point(13, -4);
		Point b = new Point(3, 10);
		Point c = new Point(1, 5);
		Point d = new Point(5, 9);

		int[] distances = getDistanceFromEachStarAscending(ref, a, b, c, d);

		System.out.println("\nPrinting distance in ascending order : ");

		for (int distance : distances) {
			if (distance != -1) {
				System.out.print(distance + " ");
			}
		}

	}

	public static int[] getDistanceFromEachStarAscending(Point ref, Point a, Point b, Point c, Point d) {

		Arrays.fill(BinaryHeap.minHeap, -1);

		double distanceFromA = Math.hypot(a.x - ref.x, a.y - ref.y);
		double distanceFromB = Math.hypot(b.x - ref.x, b.y - ref.y);
		double distanceFromC = Math.hypot(c.x - ref.x, c.y - ref.y);
		double distanceFromD = Math.hypot(d.x - ref.x, d.y - ref.y);

		System.out.println("inserting distance : " + (int) distanceFromA + " between " + ref + " and " + a);
		BinaryHeap.minHeapInsert((int) distanceFromA);

		System.out.println("inserting distance : " + (int) distanceFromB + " between " + ref + " and " + b);
		BinaryHeap.minHeapInsert((int) distanceFromB);

		System.out.println("inserting distance : " + (int) distanceFromC + " between " + ref + " and " + c);
		BinaryHeap.minHeapInsert((int) distanceFromC);

		System.out.println("inserting distance : " + (int) distanceFromD + " between " + ref + " and " + d);
		BinaryHeap.minHeapInsert((int) distanceFromD);

		BinaryHeap.printMinHeap();

		int[] distances = new int[BinaryHeap.MIN_HEAP_LIMIT];

		Arrays.fill(distances, -1);

		System.out.println("\n");

		int dst = 0;
		int currentIndex = 0;

		for (int bstIndex = BinaryHeap.CURRENT_MIN_HEAP_INDEX; bstIndex >= 0; bstIndex--) {
			if (BinaryHeap.minHeap[bstIndex] != -1) {
				dst = BinaryHeap.deleteMin();
				System.out.println("Deleted : " + dst);
				distances[currentIndex++] = dst;
				System.out.println("After deletion CURRENT_MIN_HEAP_INDEX : " + BinaryHeap.CURRENT_MIN_HEAP_INDEX);
			}

		}

		return distances;
	}

	static class Point {
		int x;
		int y;

		public Point() {

		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		
		
	}

}
