/*
 * 版权信息：广州华正道物流集团
 * 
 * 
 */
package edu.frank.sorted;

import java.util.Arrays;

/**
 * 排序公共类，提供以下排序方法<p>
 * 
 * <ul>
 * <li>冒泡排序</li>
 * <li>选择排序</li>
 * <li>插入排序</li>
 * <li>快速排序</li>
 * <li>希尔排序</li>
 * <li>基数排序</li>
 * <li>归并排序</li>
 * <li>桶排序</li>
 * <li>鸡尾酒排序</li>
 * <li>鸽巢排序</li>
 * </ul>
 * <p>
 * 
 * @author dgx
 * @since 1.0
 */
public class SortUtil {
	
	/**
	 * 冒泡排序<p>
	 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。<br>
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。<br>
	 * 针对所有的元素重复以上的步骤，除了最后一个。<br>
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。<br>
	 * 
	 * @param arr 待排序数组
	 */
	public static void bubbleSort(int arr[]) {
		int out,in,tmp;
		for (out = 0; out < arr.length-1; out++) {
			for (in = out+1; in < arr.length; in++) {
				
				if (arr[out] > arr[in]) {
					tmp = arr[out];
					arr[out] = arr[in];
					arr[in] = tmp;
				}
			}
		}
	}
	
	/**
	 * 选择排序<p>
	 * 在未排序序列中找到最小元素，存放到排序序列的起始位置。<br>
	 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。<br>
	 * 以此类推，直到所有元素均排序完毕。<br> 
	 * 
	 * @param arr 待排序数组
	 */
	public static void selectSort(int arr[]) {
		int out,in,min,tmp;
		for (out = 0; out < arr.length - 1; out++) {
			min = out;
			for (in = out+1; in < arr.length; in++) {
				if (arr[min] > arr[in]) {
					min = in;
				}
			}
			if (min != out) {
				tmp = arr[out];
				arr[out] = arr[min];
				arr[min] = tmp;
			}
		}
	}
	
	/**
	 * 插入排序<p>
	 * 从第一个元素开始，该元素可以认为已经被排序。<br>
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描。<br>
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置。<br>
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置。<br>
	 * 将新元素插入到该位置中。<br>
	 * 重复步骤2。<br>
	 * 
	 * @param arr
	 */
	public static void insertSort(int arr[]) {
		int out,in,tmp;
		for (out = 1; out < arr.length; out++) {
			tmp = arr[out];
			in = out;
			while (in>0 && arr[in-1] >= tmp) {
				arr[in] = arr[in-1];
				--in;
			}
			arr[in] = tmp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] arr = new int[]{1,5,3,2,4};
		//bubbleSort(arr);
		//selectSort(arr);
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
