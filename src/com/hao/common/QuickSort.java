package com.hao.common;

public class QuickSort {
	private  int Partition(int[] arr,int low,int high) {
		
		int pivot = arr[low];
		if(low<high) {
			while(low<high && arr[high]>pivot) high--;
			arr[low] = arr[high];
			while(low<high && arr[low]<pivot) low++;
			arr[high] = arr[low];
			
		}
		arr[low] = pivot;
		return low;
	}
	
	public void sort(int[] arr,int low,int high) {
		if(low<high) {
			int pivotPos = Partition(arr, low, high);
			sort(arr, low, pivotPos-1);
			sort(arr, pivotPos+1, high);
		}
		
	}
}
