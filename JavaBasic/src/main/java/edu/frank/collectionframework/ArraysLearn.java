/*
 * Software License
 * The file Library is
 * Copyright (C) 2010-2011 Hotel1802 Technologies Studio All Right Reserved .
 *
 * By obtaining,using,and/or copying this software and/or its associated
 * documentation, you agree that you have read, understood, and will comply
 * with the following terms and conditions :
 *
 * Permission to use, copy, modify, and distribute this file and its associated
 * documentation for any purpose and without fee is hereby granted, provide that
 * the above copyright notice appears in all copies, and that both that copyright
 * notice and this permission ontice appear in supporting documentation, and that
 * the name of Hotel802 or the author not be used in advertising or publicity
 * pertaining to distribution of the file without specific, written prior permission .
 *
 */
/**
 * Copyright : Hotel1802 All Right Reserved.
 * JDK Version : 1.6.10
 * Project : JavaBasic
 * Package : com.yoyudeng.collectionframework
 * File Name : ArraysLearn.java
 * File Version : 1.0.0.0
 *
 *
 * Author : yoyu
 * Date : 2011-3-5 03:47:34
 * History :
 * <Name>				<Date>				<Content>
 *
 */
package edu.frank.collectionframework;

/**
 * <p>
 * ArraysLearn comment
 * </p>
 *
 * @author yoyu
 * @Version JavaBasic
 */
public class ArraysLearn {

	/**
     * Tuning parameter: list size at or below which insertion sort will be
     * used in preference to mergesort or quicksort.
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;

	/**
	 * construct a new <code>ArraysLearn</code> instance for class
	 *
	 * @since JavaBasic
	 */
	public ArraysLearn() {
	}

	public static void mergeSortLearn(Object[] src, Object[] dest, int low, int high,
			int off) {
		System.out.println("Before mergeSort ...");
		System.out.print("src array: ");
		for(Object temp : src) {
			System.out.print(temp.toString() + " ");
		}

		System.out.println();
		System.out.print("dest array: ");

		for(Object temp : dest) {
			if (temp != null) {
				System.out.print(temp.toString() + " ");
			}
		}

		System.out.println();
		System.out.println("After mergeSort ...");

		mergeSort(src, dest, low, high, off);
		System.out.print("src array: ");
		for(Object temp : src) {
			System.out.print(temp.toString() + " ");
		}

		System.out.println();
		System.out.print("dest array: ");

		for(Object temp : dest) {
			if (temp != null) {
				System.out.print(temp.toString() + " ");
			}
		}
	}

	/**
     * Swaps x[a] with x[b].
     */
    private static void swap(Object[] x, int a, int b) {
	Object t = x[a];
	x[a] = x[b];
	x[b] = t;
    }

	/**
     * Src is the source array that starts at index 0
     * Dest is the (possibly larger) array destination with a possible offset
     * low is the index in dest to start sorting
     * high is the end index in dest to end sorting
     * off is the offset to generate corresponding low, high in src
     */
    private static void mergeSort(Object[] src,
				  Object[] dest,
				  int low,
				  int high,
				  int off) {
	int length = high - low;

	// Insertion sort on smallest arrays
        if (length < INSERTIONSORT_THRESHOLD) {
            for (int i=low; i<high; i++) {
				for (int j=i; j>low &&
			 ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--) {
					swap(dest, j, j-1);
				}
			}
            return;
        }

        // Recursively sort halves of dest into src
        int destLow  = low;
        int destHigh = high;
        low  += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0) {
				dest[i] = src[p++];
			} else {
				dest[i] = src[q++];
			}
        }
    }

}
