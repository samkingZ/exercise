package com.hihuaning.mixture;

import java.util.Arrays;

public class ArraysMethodDemo2 {
	public static void main(String[] args){
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		int[] arr3 = new int[5];
		Arrays.fill(arr1, 5);
		Arrays.fill(arr2, 5);
		Arrays.fill(arr3, 10);
		for(int i : arr1)
			System.out.println(i);
		if(Arrays.equals(arr1, arr2))
			System.out.println("arr1等于arr2");
		else
			System.out.println("arr1不等于arr2");
		if(Arrays.equals(arr1, arr3))
			System.out.println("arr1等于arr3");
		else
			System.out.println("arr1不等于arr3");
	}
}
