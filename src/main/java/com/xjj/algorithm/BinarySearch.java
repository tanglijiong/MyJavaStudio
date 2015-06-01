package com.xjj.algorithm;

public class BinarySearch {

	static int binSearch(int[] sourceArray, int des){
		int low=0, high=sourceArray.length-1, mid=(low+high)/2;
		
		while (low<=high) {
			if(des==sourceArray[mid]){
				return mid;
			}else if(des<sourceArray[mid]) {
				high = mid-1;
			}else {
				low = mid+1;
			}
			mid=(low+high)/2;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,7,9,12};
		
		System.out.println(binSearch(a,1));
	}
}
