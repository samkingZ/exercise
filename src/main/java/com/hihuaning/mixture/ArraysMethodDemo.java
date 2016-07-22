package com.hihuaning.mixture;


import java.util.Arrays;
import java.util.Scanner;
/**
 * Arrays类使用方法
 * sort()对指定数组排序，使用的是快速排序
 * binarySearch()对已排序的数组进行二分查找，找到指定的值就返回该值的索引，否则返回负值
 * fill() 可以使用Arrays.fill()方法将所有的元素设定为指定的值
 * equals()比较两个数组中的元素值是否全部相等，如果是就返回true，否则false
 * */
public class ArraysMethodDemo {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int[] arr = {2,1,5,223,42,12,51,3,23};
		Arrays.sort(arr);
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i]);
		int key = s.nextInt();
		int find = -1;
		if((find = Arrays.binarySearch(arr, key)) != -1)
			System.out.println(find);
		else
			System.out.println("没找到");

	}
}

